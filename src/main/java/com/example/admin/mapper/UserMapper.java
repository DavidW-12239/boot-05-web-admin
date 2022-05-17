package com.example.admin.mapper;

import com.example.admin.bean.User;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface UserMapper {

    public User getUser(Integer id);
}
