package com.example.community.mapper;

import com.example.community.model.Post;

public interface CustomizedPostMapper {
    int incView(Post record);

    int incComment(Post record);
}
