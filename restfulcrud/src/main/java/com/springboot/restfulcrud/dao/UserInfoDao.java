package com.springboot.restfulcrud.dao;

import com.springboot.restfulcrud.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {
    // display all users registration information
    public List<UserInfo> allUserInfo();

    // select user registration info by username
    public List<UserInfo> userInfoSelected(String username);

    // select user information by id
    public List<UserInfo> userInfoSelectedById(int id);

    // add user info into database
    public void addUserInfo(UserInfo userInfo);

    // update an existed user info into database
    public void updateUserInfo(UserInfo userinfo);

    // delete an existed user info from database
    public void deleteUserInfoById(int id);

}
