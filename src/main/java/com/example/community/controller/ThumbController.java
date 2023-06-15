package com.example.community.controller;

import com.example.community.dto.ResultDTO;
import com.example.community.enums.NotificationTypeEnum;
import com.example.community.mapper.CommentMapper;
import com.example.community.mapper.PostMapper;
import com.example.community.mapper.ThumbMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.*;
import com.example.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThumbController {
    @Autowired
    ThumbMapper thumbMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentService commentService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PostMapper postMapper;

    @ResponseBody
    @RequestMapping(value="/thumb/{parentId}/{userId}/{postId}", method = RequestMethod.GET)
    public Object thumb(@PathVariable(name="parentId") int parentId,
                        @PathVariable(name="userId") int userId,
                        @PathVariable(name="postId") int postId){
        ThumbExample thumbExample = new ThumbExample();
        thumbExample.createCriteria()
                .andParentIdEqualTo(parentId)
                .andUserIdEqualTo(userId);
        long totalCount = thumbMapper.countByExample(thumbExample);
        if(totalCount >= 1){
            // TODO: 撤销点赞

            return ResultDTO.success();
        }
        // Insert thumb
        Thumb thumb = new Thumb();
        thumb.setUserId(userId);
        thumb.setParentId(parentId);
        thumbMapper.insertSelective(thumb);
        // Update comment
        Comment comment = commentMapper.selectByPrimaryKey(parentId);
        ThumbExample example = new ThumbExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        long count = thumbMapper.countByExample(example);
        comment.setLikeCount((int) count);
        commentMapper.updateByPrimaryKeySelective(comment);
        // Create notification
        User commentator = userMapper.selectByPrimaryKey(userId);
        Post post = postMapper.selectByPrimaryKey(postId);
        commentService.createNotification(comment, comment.getCreator(), commentator.getName(), postId, post.getTitle(), NotificationTypeEnum.THUMB_COMMENT);

        return ResultDTO.success();
    }
}
