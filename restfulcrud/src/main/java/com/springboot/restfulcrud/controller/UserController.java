package com.springboot.restfulcrud.controller;

import com.springboot.restfulcrud.dao.UserDao;
import com.springboot.restfulcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;


    @GetMapping("/users")
    public String allUser(Model model) {
        List<User> users = userDao.getAllUser();

        // 放入请求域中
        model.addAttribute("usrs", users);
        return "user/list";
    }

    @GetMapping("/user")
    public String addUser() {
        return "user/addUser";
    }
//
//    @GetMapping("/user_security")
//    public String allUserwPW(Model model) {
//
//
//    }

}
