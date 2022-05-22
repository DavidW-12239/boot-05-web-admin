package com.example.admin.controller;

import com.example.admin.bean.Emp;
import com.example.admin.bean.User;
import com.example.admin.service.EmpService;
import com.example.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(String username, String password, HttpSession session, Model model){
        User user = new User(10, username, password);
        if(user!=null){
            //将登录的用户保存
           session.setAttribute("loginUser", user);
           log.info("index");
           return "index";
        }
        else {
            model.addAttribute("msg","sth wrong");
            return "login";
        }
        //登录成功重定向到index.html,重定向防止表单重复提交
        //return "redirect:/index.html";

    }

/*    @GetMapping("/index.html")
    public String mainPage(HttpSession session, Model model){
        //是否登录
        if (session.getAttribute("loginUser")!=null){
            return "index";
        }
        else {
            model.addAttribute("msg","do not do that");
            return "login";
        }
    }*/

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @Autowired
    EmpService empService;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDB(){
        Long amount = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        return amount.toString();
    }

/*    @ResponseBody
    @GetMapping("/user")
    public User getUser(@RequestParam("id") Integer id){
        User user = userService.getUserById(id);
        return user;
    }*/

    @ResponseBody
    @GetMapping("/getEmp")
    public Emp getEmp(@RequestParam("id") Integer id){
        Emp emp = empService.getEmp(id);
        return emp;
    }

    @ResponseBody
    @PostMapping("/saveEmp")
    public Emp saveEmp(Emp emp){
        empService.saveEmp(emp);
        return emp;
    }
}
