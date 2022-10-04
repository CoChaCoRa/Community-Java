package com.example.community.Model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreated;
    private Long gmtModified;
    private String avatarUrl;
    private String email;
}
