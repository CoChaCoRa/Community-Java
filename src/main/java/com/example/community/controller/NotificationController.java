package com.example.community.controller;

import com.example.community.dto.NotificationDTO;
import com.example.community.dto.PaginationDTO;
import com.example.community.enums.NotificationTypeEnum;
import com.example.community.model.User;
import com.example.community.service.NotificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/notification")
    public String center(HttpServletRequest request,
                         Model model,
                         @RequestParam(name="page", defaultValue = "1") Integer pageIndex,
                         @RequestParam(name="size", defaultValue = "5") Integer pageSize){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO = notificationService.getListByReceiver(user.getId(), pageIndex, pageSize);
        model.addAttribute("pagination",paginationDTO);

        return "notification";
    }

    @GetMapping("/notification/{id}")
    public String detail(HttpServletRequest request,
                          @PathVariable(name="id") Integer id){

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        NotificationDTO notificationDTO = notificationService.getById(id, user);
        if(NotificationTypeEnum.REPLY_POST.getType() == notificationDTO.getType()
        || NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType()
        || NotificationTypeEnum.THUMB_COMMENT.getType() == notificationDTO.getType()){
            return "redirect:/postDetail/" + notificationDTO.getOuterid();
        }
        return "redirect:/";
    }
}
