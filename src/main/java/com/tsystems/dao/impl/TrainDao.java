package com.tsystems.dao.impl;

import com.tsystems.dao.api.TrainDaoAPI;
import com.tsystems.entity.Train;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 06.08.2017.
 */
@Transactional
@Repository
public class TrainDao implements TrainDaoAPI{

    @Autowired
    private SessionFactory sessionFactory;

    public boolean addTrain(Train train) {
        String q = "from Train where name = :e";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", train.getName())
                .list();
        if (list != null && !list.isEmpty()) {
            return false;
        }
        sessionFactory.getCurrentSession().save(train);
        return true;
    }

    public List getAllTrains() {
        String q = "from Train";
        return sessionFactory.getCurrentSession().createQuery(q).list();
    }

    public Train getTrainByName(String train_str) {
        String q = "from Train where name = :e";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", train_str)
                .list();
        if (list != null && !list.isEmpty()) {
            return (Train) list.get(0);
        }
        return null;
    }
}
