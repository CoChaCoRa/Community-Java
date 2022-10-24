package com.example.community.controller;

import com.example.community.model.Post;
import com.example.community.model.User;
import com.example.community.dto.PostDTO;
import com.example.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public String edit(@PathVariable("id") Integer id,
                       Model model) {
        PostDTO post = postService.getPostById(id);
        model.addAttribute("title", post.getTitle());
        model.addAttribute("description", post.getDescription());
        model.addAttribute("tag", post.getTag());

        return "post";
    }

    @GetMapping("/post")
    public String post() {
        return "post";
    }

    @PostMapping("/post")
    public String doPost(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            @RequestParam(value = "id",required = false) Integer id,
            HttpServletRequest request,
            Model model
    ) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "post";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "内容不能为空");
            return "post";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "post";
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "post";
        }

        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);
        post.setTag(tag);
        post.setCreator(user.getId());
        post.setId(id);
        postService.createOrUpdate(post);
        return "redirect:/";
    }
}
