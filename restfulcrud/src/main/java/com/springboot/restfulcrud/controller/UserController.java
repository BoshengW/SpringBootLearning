package com.springboot.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {


    @GetMapping("/user")
    public String allUser() {
        return "user/list";
    }

}