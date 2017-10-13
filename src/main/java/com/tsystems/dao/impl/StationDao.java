package com.tsystems.dao.impl;

import com.tsystems.dao.api.StationDaoAPI;
import com.tsystems.entity.Station;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class StationDao implements StationDaoAPI {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean addStation(Station station) {
        String q = "from Station where name = :e";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", station.getName())
                .list();
        if (!(list != null && !list.isEmpty())) {
            sessionFactory.getCurrentSession().save(station);
            return true;
        }
        return false;
    }

    public List getAllStation() {
        String q = "from Station";
        return sessionFactory.getCurrentSession().createQuery(q).list();
    }

    public Station getStationByName(String name) {
        String q = "from Station where name = :n";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("n", name)
                .list();
        if (list != null && !list.isEmpty())
            return (Station) list.get(0);
        return null;
    }

    @Override
    public Station getStationById(Long id) {
        String q = "from Station where id = :id";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("id", id)
                .list();
        if (list != null && !list.isEmpty())
            return (Station) list.get(0);
        return null;
    }
}
