package com.example.admin.controller;

import com.example.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {

    @GetMapping(value = "/")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())){
            //将登录的用户保存
            session.setAttribute("loginUser", user);
        }
        else {
            model.addAttribute("msg","sth wrong");
            return "login";
        }
        //登录成功重定向到index.html,重定向防止表单重复提交
        return "redirect:/index.html";
    }

    @GetMapping("/index.html")
    public String mainPage(HttpSession session, Model model){
        //是否登录
        if (session.getAttribute("loginUser")!=null){
            return "index";
        }
        else {
            model.addAttribute("msg","do not do that");
            return "login";
        }

    }
}
