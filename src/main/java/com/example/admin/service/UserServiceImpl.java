package com.example.admin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.admin.bean.User;
import com.example.admin.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
