package com.ban.blogger.service;

import com.ban.blogger.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUserByIdService(int id);
    public User updateByNameAndIdService(String name, int id);
    public User deleteByIdService(int id);
    public User insertByUser(User user);

}
