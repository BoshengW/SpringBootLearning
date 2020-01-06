package com.ban.blogger.dao;

import com.ban.blogger.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getUserById(int id);
    User udpateUserByNameAndId(String name, int id);
    User insertUserByName(User user);
    User deleteUserById(int id);
}


