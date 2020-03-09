package com.springboot.restfulcrud.controller;

import com.springboot.restfulcrud.dao.UserDao;
import com.springboot.restfulcrud.dao.UserDaoImpl;
import com.springboot.restfulcrud.dao.UserInfoDao;
import com.springboot.restfulcrud.model.User;
import com.springboot.restfulcrud.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserInfoDao userInfoDao;

    //从参数上提交两个参数 username+password
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        // get the User with username
        List<UserInfo> userLogIn = userInfoDao.userInfoSelected(username);
        if(!userLogIn.isEmpty() && !StringUtils.isEmpty(userLogIn.get(0).getUsername()) && userLogIn.get(0).getPassword().equals(password)) {
            //if login successfully, to avoid POST form resubmission, we can redirect to main page
            // put attribute in session for login success user
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            map.put("msg", "登陆失败");
            return "login";
        }

    }

    @GetMapping("/register")
    public String toRegister() {
        return "/user/Register";
    }

    @PostMapping("/register")
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

        return "redirect:/";
    }



}
