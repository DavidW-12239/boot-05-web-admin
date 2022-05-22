package com.example.admin;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.admin.bean.User;
import com.example.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

/*    @Test
    void contextLoads() {
        //jdbcTemplate.queryForObject("select * from t_user");
        //jdbcTemplate.queryForList("select * from t_user");

        Long amount = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        System.out.println(amount);
        System.out.println("datasource type: " + dataSource.getClass());
    }*/

    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

}
