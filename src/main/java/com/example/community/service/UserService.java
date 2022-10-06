package com.example.community.service;

import com.example.community.Model.User;
import com.example.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertOrUpdate(User user) {

        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if (dbUser != null) {
            userMapper.update(user);
        } else {
            user.setGmtCreated(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreated());
            userMapper.insert(user);
        }
    }
}
