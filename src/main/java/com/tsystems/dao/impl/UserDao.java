package com.tsystems.dao.impl;

import com.tsystems.dao.api.UserDaoAPI;
import com.tsystems.entity.Role;
import com.tsystems.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Transactional
@Repository
public class UserDao implements UserDaoAPI {

    @Autowired
    private SessionFactory sessionFactory;

    public User checkUser(String email, String password) {
        String q = "from User where email = :e";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", email)
                .list();
        if (list != null && !list.isEmpty()) {
            User user = (User) list.get(0);
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByEmail(String email) {
        String q = "from User where email = :e";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", email)
                .list();
        if (list != null && !list.isEmpty()) {
            return (User) list.get(0);
        }
        return null;
    }

    public void addUser(User user) {
        String q = "from User where email = :e";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", user.getEmail())
                .list();
        if (!(list != null && !list.isEmpty())) {
            String q1 = "from Role where role= :r";
            List list1 = this.sessionFactory.getCurrentSession().createQuery(q1)
                    .setParameter("r", "USER")
                    .list();
            Role role = (Role) list1.get(0);
            user.setRole(role);
            this.sessionFactory.getCurrentSession().save(user);
        }
    }

    public boolean checkEmail(String email) {
        String q = "from User where email = :e";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", email)
                .list();
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }
}

