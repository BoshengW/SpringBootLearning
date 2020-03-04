package com.springboot.restfulcrud.dao;

import com.springboot.restfulcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUser() {
        String sql = "select * from user";
        List<User> allUser = jdbcTemplate.query(sql,)
    }
}
