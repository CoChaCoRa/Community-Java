package com.example.community.controller;

import com.example.community.dto.ResultDTO;
import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.model.UserExample;
import com.example.community.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(HttpServletRequest request,
                             Model model){
        String email = request.getParameter("InputEmail");
        String name = request.getParameter("InputName");
        String password1 = request.getParameter("InputPassword1");
        String password2 = request.getParameter("InputPassword2");
        String code = request.getParameter("InputActiveCode");
        Cookie[] cookies = request.getCookies();

        Boolean codeMatch = false;
        if(cookies != null && cookies.length != 0) {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("activeCode")){
                    String value = cookie.getValue();
                    if(value.equals(code)){
                        codeMatch = true;
                        break;
                    }
                }
            }
        }

        if(codeMatch && password1.equals(password2)){
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encryptedPassword = bCryptPasswordEncoder.encode(password1);
            user.setPassword(encryptedPassword);
            user.setAvatarUrl("/images/default-avatar.png");
            userService.registerUser(user);
            model.addAttribute("signupResult","success");
            return "redirect:/";
        }
        else {
            model.addAttribute("signupResult", "fail");
            return "register";
        }
    }

    @ResponseBody
    @GetMapping("/sendActiveEmail/{email}")
    public ResultDTO sendActiveEmail(HttpServletResponse response,
                                     @PathVariable(name="email") String email) throws MessagingException {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && users.size() != 0) {
            return ResultDTO.errorOf(2009,"这个邮箱已经被注册过了");
        }
        String activeCode = userService.sendEmail(email, "注册验证码");
        Cookie activeCodeCookie = new Cookie("activeCode", activeCode);
        activeCodeCookie.setPath("/");
        activeCodeCookie.setMaxAge(60 * 5);
        response.addCookie(activeCodeCookie);

        return ResultDTO.success();
    }
}
