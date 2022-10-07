package com.example.community.service;

import com.example.community.model.User;
import com.example.community.mapper.UserMapper;
import com.example.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertOrUpdate(User user) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> dbUsers = userMapper.selectByExample(userExample);
        if (dbUsers.size() != 0) {
            User dbUser = dbUsers.get(0);
            UserExample userToReplace = new UserExample();
            userToReplace.createCriteria().andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(user, userToReplace);
        } else {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }
    }
}
