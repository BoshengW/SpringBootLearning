package com.ban.blogger.service;

import com.ban.blogger.dao.UserDao;
import com.ban.blogger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserByIdService(int id) {

        return userDao.getUserById(id);
    }

    @Override
    public User updateByNameAndIdService(String name, int id) {
        return userDao.udpateUserByNameAndId(name,id);
    }

    @Override
    public User deleteByIdService(int id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public User insertByUser(User user) {
        return userDao.insertUserByName(user);
    }
}
