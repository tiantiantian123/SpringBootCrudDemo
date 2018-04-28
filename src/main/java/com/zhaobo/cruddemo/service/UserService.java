package com.zhaobo.cruddemo.service;


import com.zhaobo.cruddemo.entity.UserEntity;
import com.zhaobo.cruddemo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserJPA userJPA;

    public UserEntity login(UserEntity user){
        List<UserEntity> users = userJPA.nativeLogin(user.getT_name(),user.getT_pwd());
        if (users.size() == 1){
            user=users.get(0);
            return user;
        }
        return null;

    }

}
