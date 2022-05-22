package com.example.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.admin.bean.User;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface UserMapper extends BaseMapper<User> {


    //public User getUser(Integer id);
}
