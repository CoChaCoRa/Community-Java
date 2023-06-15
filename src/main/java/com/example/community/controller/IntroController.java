package com.example.community.controller;

import com.example.community.model.User;
import com.example.community.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {
    @Autowired
    PostService postService;

    @GetMapping("/intro")
    public String intro(HttpServletRequest request, Model model){

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        return "intro";
    }
}
