package com.tsystems.dao.impl;

import com.tsystems.dao.api.LineDaoAPI;
import com.tsystems.entity.Line;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Repository
public class LineDao implements LineDaoAPI{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean saveLine(Line line) {
        sessionFactory.getCurrentSession().save(line);
        return true;
    }

    @Transactional
    public Line getLineByName(String name) {
        String q = "from Line where denotation = :e";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", name)
                .list();
        if (list != null && !list.isEmpty()) {
            return (Line) list.get(0);
        }
        return null;
    }

    @Transactional
    public List getAllLines() {
        String q = "from Line";
        return sessionFactory.getCurrentSession().createQuery(q).list();
    }

    @Transactional
    public long getLastNumber() {
        String q = "from Line";
        return (long) sessionFactory.getCurrentSession().createQuery(q).list().size();
    }

}
