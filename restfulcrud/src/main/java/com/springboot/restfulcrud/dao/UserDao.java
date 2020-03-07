package com.springboot.restfulcrud.dao;

import com.springboot.restfulcrud.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    // display all
    public List<User> getAllUser();

    // display match user
    public User getMatchUser(String username);

}
