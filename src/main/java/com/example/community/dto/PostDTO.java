package com.example.community.dto;

import com.example.community.Model.User;
import lombok.Data;

@Data
public class PostDTO {
    private Integer id;
    private String title;
    private String description;
    private Integer creator;
    private Long gmtCreate;
    private Long gmtModified;
    private String tag;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;

    private User user;
}
