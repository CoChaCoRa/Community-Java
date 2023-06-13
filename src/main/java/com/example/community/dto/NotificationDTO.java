package com.example.community.dto;

import lombok.Data;

@Data
public class NotificationDTO {
    private Integer id;
    private Integer notifier;
    private Integer receiver;
    private Integer outer;
    private Integer type;
    private Long gmt_create;
    private Integer status;
}
