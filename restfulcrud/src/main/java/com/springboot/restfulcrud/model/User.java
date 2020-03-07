package com.springboot.restfulcrud.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String username;
    private String user_group;
    private Date regst_date;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_group() {
        return user_group;
    }

    public void setUser_group(String user_group) {
        this.user_group = user_group;
    }

    public Date getRegst_date() {
        return regst_date;
    }

    public void setRegst_date(Date regst_date) {
        this.regst_date = regst_date;
    }
}
