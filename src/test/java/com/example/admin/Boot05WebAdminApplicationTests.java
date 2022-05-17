package com.example.admin;

import com.alibaba.druid.pool.DruidDataSource;
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

    @Test
    void contextLoads() {
        //jdbcTemplate.queryForObject("select * from t_user");
        //jdbcTemplate.queryForList("select * from t_user");

        Long amount = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        System.out.println(amount);
        System.out.println("datasource type: " + dataSource.getClass());

    }

}
