package com.springboot.restfulcrud.mapper;

import com.springboot.restfulcrud.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User newUser = new User();
        newUser.setId(resultSet.getInt("id"));
        newUser.setUsername(resultSet.getString("username"));
        newUser.setUser_group(resultSet.getString("user_group"));
        newUser.setRegst_date(resultSet.getDate("regst_date"));
        return newUser;
    }

}
