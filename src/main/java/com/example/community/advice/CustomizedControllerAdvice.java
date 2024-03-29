package com.example.community.advice;

import com.alibaba.fastjson2.JSON;
import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.Exception.CustomizedException;
import com.example.community.dto.ResultDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomizedControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleControllerException(Throwable ex,
                                                  Model model,
                                                  HttpServletRequest request,
                                                  HttpServletResponse response) {

        String contentType = request.getContentType();
        if ("application/json".equals(contentType)){
            ResultDTO resultDTO;
            //返回json
            if (ex instanceof CustomizedException){
                resultDTO = ResultDTO.errorOf((CustomizedException) ex);
            }else{
                resultDTO = ResultDTO.errorOf(CustomizedErrorCode.SYS_ERROR);
            }

            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();

            } catch (IOException ioe) {
            }
            return null;
        }else {
            //错误页面跳转
            if (ex instanceof CustomizedException){
                model.addAttribute("message",ex.getMessage());
            }else{
                model.addAttribute("message",CustomizedErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }

}

