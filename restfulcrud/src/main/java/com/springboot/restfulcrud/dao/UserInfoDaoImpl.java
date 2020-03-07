package com.springboot.restfulcrud.dao;

import com.springboot.restfulcrud.mapper.UserInfoMapper;
import com.springboot.restfulcrud.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
}
