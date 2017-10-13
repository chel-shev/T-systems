package com.tsystems.dao.impl;

import com.tsystems.dao.api.StageDaoAPI;
import com.tsystems.entity.Line;
import com.tsystems.entity.Stage;
import com.tsystems.entity.Station;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StageDao implements StageDaoAPI {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveStage(Stage stage) {
        sessionFactory.getCurrentSession().save(stage);
    }

    public List getToStageByName(String from) {
        String q = "from Station where name= :e";
        List listStation = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", from)
                .list();
        Station station = (Station) listStation.get(0);
        String q1 = "from Stage where to_station_id= :e";
        return sessionFactory.getCurrentSession().createQuery(q1)
                .setParameter("e", station)
                .list();
    }

    public List getFromStageByName(String from) {
        String q = "from Station where name= :e";
        List listStation = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", from)
                .list();
        Station station = (Station) listStation.get(0);
        String q1 = "from Stage where from_station_id= :e";
        return sessionFactory.getCurrentSession().createQuery(q1)
                .setParameter("e", station)
                .list();
    }

    public Stage getStageByNameAndLine(String to, Line line) {
        String q = "from Station where name= :e";
        List listStation = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", to)
                .list();
        Station station = (Station) listStation.get(0);
        String q1 = "from Stage where to_station_id= :e and line_id=:l";
        List list = sessionFactory.getCurrentSession().createQuery(q1)
                .setParameter("e", station)
                .setParameter("l", line)
                .list();
        if (list.isEmpty()) {
            return null;
        } else {
            return (Stage) list.get(0);
        }

    }

    public Stage getByLineAndNumber(Line line, int num) {
        String q = "from Stage where line_id= :e and number=:n";
        List listStage = sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", line)
                .setParameter("n", num)
                .list();
        return (Stage) listStage.get(0);
    }

    public List getStageByLineId(Line line_id) {
        String q = "from Stage where line_id= :e";
        return sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", line_id)
                .list();
    }
}
