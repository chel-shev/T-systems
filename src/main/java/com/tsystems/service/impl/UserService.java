package com.tsystems.service.impl;

import com.tsystems.dao.api.UserDaoAPI;
import com.tsystems.entity.User;
import com.tsystems.service.api.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserServiceAPI{

    @Autowired
    private UserDaoAPI userDao;

    public User checkUser(String login, String password){
        return userDao.checkUser(login, password);
    }
    
    public boolean checkEmail(String email) {
        return userDao.checkEmail(email);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
