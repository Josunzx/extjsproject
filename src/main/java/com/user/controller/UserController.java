package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("/getUser")
    public String test(Model model) {
        model.addAttribute("user", "admin");
        return "login";
    }
}