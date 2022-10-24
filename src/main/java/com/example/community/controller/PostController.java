package com.example.community.controller;

import com.example.community.dto.CommentDTO;
import com.example.community.dto.PaginationDTO;
import com.example.community.dto.PostDTO;
import com.example.community.enums.CommentTypeEnum;
import com.example.community.service.CommentService;
import com.example.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/postDetail/{id}")
    public String getPost(@PathVariable(name="id") Integer id,
                          Model model) {
        postService.incView(id);
        PostDTO postDTO = postService.getPostById(id);
        model.addAttribute("post", postDTO);

        List<CommentDTO> comments = commentService.getListByParentId(id, CommentTypeEnum.POST);
        model.addAttribute("comments",comments);

        List<PostDTO> relatedPosts = postService.getRelatedListByTag(id);
        model.addAttribute("relatedPosts", relatedPosts);

        return "postDetail";
    }
}
