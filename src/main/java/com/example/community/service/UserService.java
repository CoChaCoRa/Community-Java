package com.example.community.service;

import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.model.UserExample;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RandomCodeService randomCodeService;
    @Autowired
    private MailService mailService;

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
            userMapper.insertSelective(user);
        }
    }

    public void registerUser(User user){
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        String accountId = randomCodeService.CreateAccountId();
        user.setAccountId(accountId);
        userMapper.insertSelective(user);
    }

    public String sendEmail(String email, String role) throws MessagingException {
        String activeCode = randomCodeService.createActiveCode();
        String subject = "来自BBS的用户注册激活邮件";
        String context = "【激活码五分钟有效】"+role+":"+activeCode+"";
        mailService.sendEmail(email,subject,context);
        return activeCode;
    }
}
