package com.springboot.restfulcrud.dao;

import com.springboot.restfulcrud.mapper.UserInfoMapper;
import com.springboot.restfulcrud.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<UserInfo> allUserInfo() {
        String sql = "select * from userinfo;";
        List<UserInfo> allUserInfo = jdbcTemplate.query(sql, new UserInfoMapper());
        return allUserInfo;
    }

    @Override
    public List<UserInfo> userInfoSelected(String username) {
        String sql = "select * from userinfo where username=?;";
        // Note: you need to consider queryforObject only allow return one row, cannot return 0 or more than 1 row.
        // how to handle 0 / >1 row situation -> not use Query for Object you can use query
        List<UserInfo> userInfoSelect = jdbcTemplate.query(sql, new UserInfoMapper(), username);
        return userInfoSelect;
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {

        // 一共有三种方法实现jdbctemplate的update或insert
        // 第一种重写PreparedStatementSetter
        String sql = "insert into userinfo (username,email,password) " +
                "values (?,?,?);";

        int row = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, userInfo.getUsername());
                preparedStatement.setString(2,userInfo.getEmail());
                preparedStatement.setString(3,userInfo.getPassword());
            }
        });
    }
}
