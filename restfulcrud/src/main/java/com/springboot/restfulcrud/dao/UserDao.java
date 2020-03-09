package com.springboot.restfulcrud.dao;

import com.springboot.restfulcrud.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    // display all
    public List<User> getAllUser();

    // display match user
    public List<User> getMatchUser(String username);

    // add user (user_group, register date) into database
    public void addUserPrivil(User user);

    // update existed user into database
    public void updateUser(String username, int id);

    // delete existed user from database
    public void deleteUserById(int id);

}
