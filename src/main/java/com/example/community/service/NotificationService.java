package com.example.community.service;

import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.Exception.CustomizedException;
import com.example.community.dto.NotificationDTO;
import com.example.community.dto.PaginationDTO;
import com.example.community.enums.NotificationStatusEnum;
import com.example.community.enums.NotificationTypeEnum;
import com.example.community.mapper.NotificationMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Notification;
import com.example.community.model.NotificationExample;
import com.example.community.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationMapper notificationMapper;
    @Autowired
    UserMapper userMapper;

    public PaginationDTO getListByReceiver(Integer receiver, Integer pageIndex, Integer pageSize){
        PageHelper.startPage(pageIndex, pageSize);
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(receiver);
        List<Notification> notifications = notificationMapper.selectByExample(notificationExample);
        notificationExample.clear();
        notificationExample.createCriteria().andReceiverEqualTo(receiver);
        long totalCount = notificationMapper.countByExample(notificationExample);
        PaginationDTO paginationDTO = createPaginationDTO(notifications, totalCount, pageIndex, pageSize);

        return paginationDTO;
    }

    private PaginationDTO createPaginationDTO(List<Notification> notifications, long totalCount, Integer pageIndex, Integer pageSize) {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPaginationDTO(totalCount, pageIndex, pageSize);

        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        for(Notification notification: notifications){
            NotificationDTO notificationDTO = createNotificationDTO(notification);
            notificationDTOList.add(notificationDTO);
        }

        paginationDTO.setData(notificationDTOList);
        return paginationDTO;
    }

    private NotificationDTO createNotificationDTO(Notification notification) {
        User notifierUser = userMapper.selectByPrimaryKey(notification.getNotifier());
        NotificationDTO notificationDTO = new NotificationDTO();
        BeanUtils.copyProperties(notification, notificationDTO);
        notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
        notificationDTO.setNotifierUser(notifierUser);

        return notificationDTO;
    }

    public NotificationDTO getById(Integer id, User user){
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        if(notification == null){
            throw new CustomizedException(CustomizedErrorCode.NOTIFICATION_NOT_FOUND);
        }
        if(notification.getReceiver() != user.getId()){
            throw new CustomizedException(CustomizedErrorCode.READ_NOTIFICATION_FAIL);
        }

        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);

        NotificationDTO notificationDTO = new NotificationDTO();
        BeanUtils.copyProperties(notification,notificationDTO);
        notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));

        return notificationDTO;
    }
}
