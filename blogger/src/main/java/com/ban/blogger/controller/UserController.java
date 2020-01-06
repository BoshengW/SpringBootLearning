package com.ban.blogger.controller;

import com.ban.blogger.model.User;
import com.ban.blogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUser() {
        List<User> user = userService.getUserByIdService(1);

        return user;
    }
    @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable int id) {
        User user = userService.deleteByIdService(id);
        return user;
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {

        User newUser = userService.insertByUser(user);

        return newUser;
    }

//    @PutMapping("/update")
//    public User updateUser() {
//        User user = userService.updateByNameAndIdService(name, id)
//    }
}
