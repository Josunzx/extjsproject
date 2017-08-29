package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.entity.UserEntity;
import com.user.service.UserSevice;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserSevice userService;

    @RequestMapping("/getUser")
    public @ResponseBody UserEntity test() {
        UserEntity user = this.userService.getUserByName("admin");
        return user;
    }
}