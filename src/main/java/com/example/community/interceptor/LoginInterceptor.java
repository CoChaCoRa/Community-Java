package com.example.community.interceptor;

import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.Exception.CustomizedException;
import com.example.community.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //未登录进行拦截，防止回退历史操作
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            throw new CustomizedException(CustomizedErrorCode.NO_LOGIN);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
