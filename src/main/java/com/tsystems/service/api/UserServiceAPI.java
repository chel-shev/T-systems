package com.tsystems.service.api;

import com.tsystems.entity.User;

public interface UserServiceAPI {

    User checkUser(String login, String password);

    boolean checkEmail(String email);

    void addUser(User user);
}
