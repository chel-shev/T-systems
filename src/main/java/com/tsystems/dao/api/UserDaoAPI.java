package com.tsystems.dao.api;

import com.tsystems.entity.User;

public interface UserDaoAPI {

    User checkUser(String email, String password);

    User getUserByEmail(String email);

    void addUser(User user);

    boolean removeUser();

    boolean updateUser();

    boolean checkEmail(String email);
}

