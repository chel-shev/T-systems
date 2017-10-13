package com.tsystems.bean;

import com.tsystems.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class UserBean {

    private static final Logger logger = LoggerFactory.getLogger(UserBean.class);

    private String email;
    private String first_name;
    private String last_name;
    private Date birthday;
    private String role;

    public UserBean() {

    }

    public UserBean(User user) {
        this.email = user.getEmail();
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.birthday = user.getBirthday();
        this.role = user.getRole().getRole();
    }

    public UserBean(String email, String first_name, String last_name, Date birthday, String role) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.role = role;
    }

    public void setData(User user) {
        this.email = user.getEmail();
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.birthday = user.getBirthday();
        this.role = user.getRole().getRole();
        logger.info("email: " + user.getEmail() + " first_name: " + user.getFirst_name() + " last_nameL: " +
                user.getLast_name() + " birthday: " + user.getBirthday().toString() + " role: " + user.getRole().getRole());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void cleanUser() {
        this.email = null;
        this.first_name = null;
        this.last_name = null;
        this.birthday = null;
        this.role = null;
    }
}