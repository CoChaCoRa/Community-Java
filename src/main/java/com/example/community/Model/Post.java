package com.example.community.Model;

import lombok.Data;

@Data
public class Post {
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

}
