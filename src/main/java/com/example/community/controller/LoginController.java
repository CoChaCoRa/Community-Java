package com.example.community.controller;

import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.model.UserExample;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(HttpServletRequest request,
                          HttpServletResponse response,
                          Model model){
        String email = request.getParameter("InputEmail");
        String password = request.getParameter("InputPassword1");
        String rememberFlag = request.getParameter("rememberFlag"); // rememberFlag != null

        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && users.size() != 0){
            User user = users.get(0);
            String encryptedPassword = user.getPassword();
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            boolean matches = bCryptPasswordEncoder.matches(password, encryptedPassword);
            if(matches){
                String token = UUID.randomUUID().toString();
                user.setToken(token);
                userMapper.updateByPrimaryKeySelective(user);
                Cookie cookie = new Cookie("token", token);
                cookie.setPath("/");
                if(rememberFlag != null) {
                    cookie.setMaxAge(60 * 60 * 24);
                }
                response.addCookie(cookie);
                return "redirect:/";
            }
            else{
                model.addAttribute("loginFail", "密码不正确");
                return "login";
            }
        }
        else {
            model.addAttribute("loginFail", "无该用户");
            return "login";
        }
    }
}
