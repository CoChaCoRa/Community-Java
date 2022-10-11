package com.example.community.service;

import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.Exception.CustomizedException;
import com.example.community.dto.CommentDTO;
import com.example.community.enums.CommentTypeEnum;
import com.example.community.mapper.CommentMapper;
import com.example.community.mapper.CustomizedPostMapper;
import com.example.community.mapper.PostMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Comment;
import com.example.community.model.CommentExample;
import com.example.community.model.Post;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CustomizedPostMapper customizedPostMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizedException(CustomizedErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getParentType() == null || !CommentTypeEnum.contains(comment.getParentType())) {
            throw new CustomizedException(CustomizedErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getParentType() == CommentTypeEnum.POST.getType()) {
            // 回复post
            Post dbPost = postMapper.selectByPrimaryKey(comment.getParentId());
            if (dbPost == null) {
                throw new CustomizedException(CustomizedErrorCode.POST_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            dbPost.setCommentCount(1);
            customizedPostMapper.incComment(dbPost);
        } else {
            // 回复comment
            Comment dbComment = commentMapper.selectByPrimaryKey(Long.valueOf(comment.getParentId()));
            if (dbComment == null) {
                throw new CustomizedException(CustomizedErrorCode.COMMENT_NOT_FOUND);
            }
            Post dbPost = postMapper.selectByPrimaryKey(dbComment.getParentId());
            if (dbPost == null) {
                throw new CustomizedException(CustomizedErrorCode.POST_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            dbPost.setCommentCount(1);
            customizedPostMapper.incComment(dbPost);
        }
    }

    public List<CommentDTO> getListByParentId(Integer id, CommentTypeEnum type) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria()
                .andParentIdEqualTo(id)
                .andParentTypeEqualTo(type.getType());
        commentExample.setOrderByClause("gmt_create desc");
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        if(comments.size() == 0) return new ArrayList<>();

        List<CommentDTO> commentDTOs = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTO.setUser(userMapper.selectByPrimaryKey(comment.getCreator()));
            return commentDTO;
        }).collect(Collectors.toList());

        return commentDTOs;
    }
}
