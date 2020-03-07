package com.springboot.restfulcrud.mapper;


import com.springboot.restfulcrud.model.UserInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoMapper implements RowMapper<UserInfo> {

    @Override
    public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        UserInfo newUserInfo = new UserInfo();
        newUserInfo.setId(resultSet.getInt("id"));
        newUserInfo.setUsername(resultSet.getString("username"));
        newUserInfo.setEmail(resultSet.getString("email"));
        newUserInfo.setPassword(resultSet.getString("password"));
        return newUserInfo;
    }

}

