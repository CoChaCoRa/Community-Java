package com.example.community.advice;

import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.Exception.CustomizedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomizedControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleControllerException(Throwable ex,
                                                  Model model,
                                                  HttpServletRequest request) {
        if(ex instanceof CustomizedException) {
            model.addAttribute("code", ((CustomizedException) ex).getCode());
            model.addAttribute("message", ex.getMessage());
        } else {
            model.addAttribute("code", CustomizedErrorCode.SYS_ERROR.getCode());
            model.addAttribute("message", CustomizedErrorCode.SYS_ERROR.getMessage());
        }
        return new ModelAndView("error");
    }

}

