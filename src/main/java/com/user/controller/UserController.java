package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.entity.UserEntity;
import com.user.service.UserSevice;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserSevice userService;

    @RequestMapping("/getUserbyName/{username}")
    public @ResponseBody List<UserEntity> getUsers() {
        return this.userService.getUsers();
    }

    @RequestMapping("/getUserbyName/{username}")
    public @ResponseBody UserEntity getUserbyName(@PathVariable String username) {
        UserEntity user = this.userService.getUserByName(username);
        return user;
    }

    @RequestMapping("/getUserbyId/{id}")
    public @ResponseBody UserEntity getUserbyId(@PathVariable int id) {
        UserEntity user = this.userService.getUserById(id);
        return user;
    }
}