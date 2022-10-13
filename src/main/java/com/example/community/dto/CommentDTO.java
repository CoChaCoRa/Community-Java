package com.example.community.dto;

import com.example.community.model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Integer id;
    private Integer parentId;
    private Integer parentType;
    private Integer creator;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}
