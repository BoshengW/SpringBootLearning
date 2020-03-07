package com.springboot.restfulcrud.controller;

import com.springboot.restfulcrud.dao.UserDao;
import com.springboot.restfulcrud.dao.UserInfoDao;
import com.springboot.restfulcrud.model.User;
import com.springboot.restfulcrud.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.sql.Date;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    UserInfoDao userInfoDao;


    @GetMapping("/users")
    public String allUser(Model model) {
        List<User> users = userDao.getAllUser();

        // 放入请求域中
        model.addAttribute("usrs", users);
        return "user/list";
    }

    @GetMapping("/user")
    public String jump2addUser() {
        return "user/addUser";
    }

    @PostMapping("/user")
    public String addUser(UserInfo userInfo) {

        //check username and password ? check email
        List<User> checkUserExist = userDao.getMatchUser(userInfo.getUsername());

        // check if username exist
        if(checkUserExist.isEmpty()) {
            //在这里如果直接写"/users" 会进入GetMapping控制器进行重新解析效率比较低
            // redirect: 表示重定向到一个地址
            // forward: 表示转发到一个地址

            // get current date and add user detail into User object
            User newUser = new User();
            LocalDate localDate = LocalDate.now();
            Date sqlDate = Date.valueOf(localDate);
                //        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                //        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // add newUser into user table
            newUser.setUser_group("user");
            newUser.setRegst_date(sqlDate);
            newUser.setUsername(userInfo.getUsername());
            userDao.addUserPrivil(newUser);

            // add newUserInfo into userinfo table
            userInfoDao.addUserInfo(userInfo);
        }

        return "redirect:/users";
    }

}
