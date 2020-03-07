package com.springboot.restfulcrud.controller;

import com.springboot.restfulcrud.dao.UserDao;
import com.springboot.restfulcrud.dao.UserDaoImpl;
import com.springboot.restfulcrud.dao.UserInfoDao;
import com.springboot.restfulcrud.model.User;
import com.springboot.restfulcrud.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
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
}
