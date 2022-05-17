package com.example.admin.service;

import com.example.admin.mapper.UserMapper;
import com.example.admin.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserById(Integer id){
        User user = userMapper.getUser(id);
        return user;
    }
}

