package com.ban.blogger.dao;

import com.ban.blogger.mapper.UserMapper;
import com.ban.blogger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;


// 把这个UserDaoImpl 变成 spring bean
@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUserById(int id) {
        String sql = "select * from User where id=?;";
        RowMapper mapper = new UserMapper();
        List<User> list = (List) jdbcTemplate.query(sql,mapper,id);

        return list;
    }

    @Override
    public User udpateUserByNameAndId(String name, int id) {
        String sql = "update User set name=? where id=?;";
        User user = (User) jdbcTemplate.queryForList(sql);
        return user;
    }

    @Override
    public User insertUserByName(User user) {
        String sql = "insert into User value(?,?,?);";
        User user1 = (User) jdbcTemplate.query(sql, new UserMapper(), user.getId(),user.getName(), user.getPassword());
        System.out.println(user1);
        return user1;
    }

    @Override
    public User deleteUserById(int id) {
        String sql = "delete from User where id=?;";
        User user = (User) jdbcTemplate.query(sql,new UserMapper(),id);
        return user;
    }
}
