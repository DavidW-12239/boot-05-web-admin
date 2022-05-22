package com.example.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.admin.bean.User;
import com.example.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("dynamic_table")
    public String dynamic_table(Model model){
        /*//表格内容动态遍历
        List<User> users = Arrays.asList(new User(1,"david", "12345"), new User(2, "Alice", "12345"),
                new User(3, "Jade", "12345"), new User(4, "Zoe", "12345"));
        model.addAttribute("users", users);*/
        List<User> users = userService.list();
        model.addAttribute("users", users);
        return "table/dynamic_table";
    }

    @GetMapping("responseive_table")
    public String responseive_table(){
        return "table/responseive_table";
    }

    @GetMapping("editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.removeById(id);
        return "redirect:/dynamic_table";
    }

}
