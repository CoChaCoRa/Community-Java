package com.example.community.service;

import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.Exception.CustomizedException;
import com.example.community.enums.CommentTypeEnum;
import com.example.community.mapper.CommentMapper;
import com.example.community.mapper.CustomizedPostMapper;
import com.example.community.mapper.PostMapper;
import com.example.community.model.Comment;
import com.example.community.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CustomizedPostMapper customizedPostMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Transactional
    public void insert(Comment comment) {
        if(comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizedException(CustomizedErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if(comment.getParentType() == null || !CommentTypeEnum.contains(comment.getParentType())) {
            throw new CustomizedException(CustomizedErrorCode.TYPE_PARAM_WRONG);
        }
        if(comment.getParentType() == CommentTypeEnum.POST.getType()) {
            // 回复post
            Post dbPost = postMapper.selectByPrimaryKey(comment.getParentId());
            if(dbPost == null) {
                throw new CustomizedException(CustomizedErrorCode.POST_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            dbPost.setCommentCount(1);
            customizedPostMapper.incComment(dbPost);
        }
        else {
            // 回复comment
            Comment dbComment = commentMapper.selectByPrimaryKey(Long.valueOf(comment.getParentId()));
            if(dbComment == null) {
                throw new CustomizedException(CustomizedErrorCode.COMMENT_NOT_FOUND);
            }
            Post dbPost = postMapper.selectByPrimaryKey(dbComment.getParentId());
            if(dbPost == null) {
                throw new CustomizedException(CustomizedErrorCode.POST_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            dbPost.setCommentCount(1);
            customizedPostMapper.incComment(dbPost);
        }
    }
}
