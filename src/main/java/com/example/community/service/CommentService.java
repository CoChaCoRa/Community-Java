package com.example.community.service;

import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.Exception.CustomizedException;
import com.example.community.dto.CommentDTO;
import com.example.community.dto.PaginationDTO;
import com.example.community.enums.CommentTypeEnum;
import com.example.community.enums.NotificationStatusEnum;
import com.example.community.enums.NotificationTypeEnum;
import com.example.community.mapper.*;
import com.example.community.model.*;
import com.github.pagehelper.PageHelper;
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
    private CustomizedCommentMapper customizedCommentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NotificationMapper notificationMapper;

    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizedException(CustomizedErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getParentType() == null || !CommentTypeEnum.contains(comment.getParentType())) {
            throw new CustomizedException(CustomizedErrorCode.TYPE_PARAM_WRONG);
        }
        User user = userMapper.selectByPrimaryKey(comment.getCreator());
        if (comment.getParentType() == CommentTypeEnum.POST.getType()) {
            // 回复post
            Post dbPost = postMapper.selectByPrimaryKey(comment.getParentId());
            if (dbPost == null) {
                throw new CustomizedException(CustomizedErrorCode.POST_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            dbPost.setCommentCount(1);
            customizedPostMapper.incComment(dbPost);
            // 创建消息通知
            createNotification(comment, dbPost.getCreator(), user.getName(), dbPost.getId(), dbPost.getTitle(), NotificationTypeEnum.REPLY_POST);
        } else {
            // 回复comment
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizedException(CustomizedErrorCode.COMMENT_NOT_FOUND);
            }
            Post dbPost = postMapper.selectByPrimaryKey(dbComment.getParentId());
            if (dbPost == null) {
                throw new CustomizedException(CustomizedErrorCode.POST_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            Comment parentComment = new Comment();
            parentComment.setId(comment.getParentId());
            parentComment.setCommentCount(1);
            customizedCommentMapper.incComment(parentComment);
            dbPost.setCommentCount(1);
            customizedPostMapper.incComment(dbPost);
            // 创建消息通知
            createNotification(comment, dbComment.getCreator(), user.getName(), dbPost.getId(), dbPost.getTitle(), NotificationTypeEnum.REPLY_COMMENT);
        }
    }

    public void createNotification(Comment comment, Integer receiver, String notifierName, Integer outerId, String outerTitle, NotificationTypeEnum notificationTypeEnum){
//        if(comment.getCreator() == receiver){
//            return;
//        }
        Notification notification = new Notification();
        notification.setReceiver(receiver);
        notification.setNotifier(comment.getCreator());
        notification.setNotifierName(notifierName);
        notification.setOuterid(outerId);
        notification.setOuterTitle(outerTitle);
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setType(notificationTypeEnum.getType());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());

        notificationMapper.insertSelective(notification);
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

    public PaginationDTO getListByCreator(Integer id, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andCreatorEqualTo(id);
        commentExample.setOrderByClause("gmt_create desc");
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        commentExample.clear();
        commentExample.createCriteria().andCreatorEqualTo(id);
        long totalCount = commentMapper.countByExample(commentExample);

        PaginationDTO paginationDTO = createPaginationDTO(comments, totalCount, pageIndex, pageSize);

        return paginationDTO;
    }

    public CommentDTO createCommentDTO(Comment comment) {
        User user = userMapper.selectByPrimaryKey(comment.getCreator());
        CommentDTO commentDTO = new CommentDTO();
        BeanUtils.copyProperties(comment, commentDTO);
        commentDTO.setUser(user);

        return commentDTO;
    }

    public PaginationDTO createPaginationDTO(List<Comment> comments,
                                             long totalCount,
                                             Integer pageIndex,
                                             Integer pageSize) {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPaginationDTO(totalCount, pageIndex, pageSize);

        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDTO commentDTO = createCommentDTO(comment);
            commentDTOList.add(commentDTO);
        }

        paginationDTO.setData(commentDTOList);
        return paginationDTO;
    }
}
