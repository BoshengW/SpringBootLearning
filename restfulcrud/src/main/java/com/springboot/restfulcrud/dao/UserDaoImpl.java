package com.springboot.restfulcrud.dao;

import com.springboot.restfulcrud.mapper.UserMapper;
import com.springboot.restfulcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUser() {
        String sql = "select * from user";
        List<User> allUser = jdbcTemplate.query(sql, new UserMapper());
        return allUser;

    }

    @Override
    public List<User> getMatchUser(String username) {
        String sql = "select * from user where username=?";
        List<User> userSelected = jdbcTemplate.query(sql, new UserMapper(), username);
        return userSelected;
    }

    @Override
    public void addUserPrivil(User user) {
        // 第二种方法直接写sql -> 好蠢
        // 第三种重写PreStatementCreator

        // convert localDate into sql date
        int row = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "insert into user (username,regst_date,user_group) values (?,?,?);";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1,user.getUsername());
                ps.setDate(2, user.getRegst_date());
                ps.setString(3, user.getUser_group());
                return ps;
            }
        });
    }

    @Override
    public void updateUser(String username, int id) {
        String sql = "update user set username=? where id=?;";
        int row = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,username);
                preparedStatement.setInt(2,id);
            }
        });
    }

    @Override
    public void deleteUserById(int id) {
        String sql = "delete from user where id=?;";
        jdbcTemplate.update(sql,id);
    }

}
