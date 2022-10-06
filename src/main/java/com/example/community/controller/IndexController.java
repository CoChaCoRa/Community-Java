package com.example.community.controller;

import com.example.community.Model.User;
import com.example.community.dto.PaginationDTO;
import com.example.community.mapper.UserMapper;
import com.example.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name="page", defaultValue = "1") Integer pageIndex,
                        @RequestParam(name="size", defaultValue = "10") Integer pageSize) {

        PaginationDTO paginationDTO = postService.getList(pageIndex,pageSize);
        model.addAttribute("pagination",paginationDTO);

        return "index";
    }

}