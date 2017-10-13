package com.tsystems.dao.impl;

import com.tsystems.dao.api.AtomicTravelDaoAPI;
import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Line;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AtomicTravelDao implements AtomicTravelDaoAPI {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveTrip(AtomicTravel atomicTravel) {
        sessionFactory.getCurrentSession().save(atomicTravel);
    }

    public List getAllAtomicTravel() {
        String q = "from AtomicTravel";
        return sessionFactory.getCurrentSession().createQuery(q).list();
    }

    public List getAtomicTravelByLine(Line line) {
        String q = "from AtomicTravel where line_id = :e";
        return sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", line)
                .list();
    }

    public AtomicTravel getAtomicTravelById(long id) {
        String q = "from AtomicTravel where atom_travel_id = :e";
        List list = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", id)
                .list();
        if (list != null && !list.isEmpty()) {
            return (AtomicTravel) list.get(0);
        }
        return null;
    }
}
