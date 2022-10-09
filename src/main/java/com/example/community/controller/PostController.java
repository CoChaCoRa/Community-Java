package com.example.community.controller;

import com.example.community.dto.PostDTO;
import com.example.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/postDetail/{id}")
    public String getPost(@PathVariable(name="id") Integer id,
                          Model model) {
        postService.incView(id);
        PostDTO postDTO = postService.getPostById(id);
        model.addAttribute("post", postDTO);

        return "postDetail";
    }
}
