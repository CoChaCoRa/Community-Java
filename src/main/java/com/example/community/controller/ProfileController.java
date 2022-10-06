package com.example.community.controller;

import com.example.community.Model.User;
import com.example.community.dto.PaginationDTO;
import com.example.community.mapper.UserMapper;
import com.example.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PostService postService;

    @GetMapping("/profile/{section}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "section", value = "") String section,
                          Model model,
                          @RequestParam(name="page", defaultValue = "1") Integer pageIndex,
                          @RequestParam(name="size", defaultValue = "5") Integer pageSize) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("section", section);
        switch (section) {
            case "myPosts":
                model.addAttribute("sectionName","我的帖子");
                break;
            case "myReplies":
                model.addAttribute("sectionName","我的回复");
                break;
            default:
                model.addAttribute("sectionName","");
        }

        PaginationDTO paginationDTO = postService.getListByCreator(user.getId(),pageIndex,pageSize);
        model.addAttribute("pagination",paginationDTO);

        return "profile";
    }
}
