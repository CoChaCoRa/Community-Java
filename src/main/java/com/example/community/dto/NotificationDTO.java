package com.example.community.dto;

import com.example.community.model.User;
import lombok.Data;

@Data
public class NotificationDTO {
    private Integer id;
    private Integer notifier;
    private String notifierName;
    private Integer receiver;
    private Integer outerid;
    private String outerTitle;
    private Integer type;
    private String typeName;
    private Long gmt_create;
    private Integer status;
    private User notifierUser;
}
