package com.example.community.controller;

import com.google.code.kaptcha.Producer;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class ImageCodeController {
    @Autowired
    Producer producer;
    @GetMapping("/imageCode")
    public void getImageCode(HttpServletRequest request,
                             HttpServletResponse response){
        String codeText = producer.createText();
        BufferedImage codeImage = producer.createImage(codeText);
        request.getSession().setAttribute("kaptchaCode",codeText);
        response.setContentType("image/jpg");

        try{
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(codeImage, "jpg", outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
