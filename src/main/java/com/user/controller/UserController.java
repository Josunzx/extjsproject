package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.entity.UserEntity;
import com.user.service.UserSevice;
import com.util.Page;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserSevice userService;

    @RequestMapping("/getUsers")
    public @ResponseBody Page<UserEntity> getUsers(@RequestParam(
            defaultValue = "0") int start,
            @RequestParam(defaultValue = "25") int size,
            @RequestParam() String query) {
        System.out.println("查询条件为：" + query);
        Page<UserEntity> page = this.userService.getUsers(start, size);
        return page;
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