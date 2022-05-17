package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile自动封装上传文件
     * @param email
     * @param username
     * @param avatar
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email, @RequestParam("username") String username,
                         @RequestPart("avatar") MultipartFile avatar, @RequestPart("photos") MultipartFile[] photos) throws IOException {

        if(!avatar.isEmpty()){
            //保存到文件服务器，OSS服务器
            String originalFilename = avatar.getOriginalFilename();
            avatar.transferTo(new File("E:\\sesede\\" + originalFilename));
        }

        if(photos.length>0){
            for(MultipartFile photo : photos){
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\sesede\\" + originalFilename));
                }
            }
        }

        return "index";
    }
}


