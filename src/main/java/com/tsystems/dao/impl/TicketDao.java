package com.tsystems.dao.impl;

import com.tsystems.dao.api.TicketDaoAPI;
import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Ticket;
import com.tsystems.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class TicketDao implements TicketDaoAPI {

    @Autowired
    private SessionFactory sessionFactory;

    public void buyTicket(User user, AtomicTravel atomicTravel, int numSit, int numCar , String s_from, String s_to) {
        String q = "update Ticket set s_from = :sFrom, s_to = :sTo, user_id = :user" +
                " where numCar = :numCar and numTicket = :numSit and atom_travel_id = :atomicTravel";
        sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("sFrom", s_from)
                .setParameter("sTo", s_to)
                .setParameter("user", user)
                .setParameter("atomicTravel", atomicTravel)
                .setParameter("numSit", numSit)
                .setParameter("numCar", numCar)
                .executeUpdate();

    }

    public long getTicketByAtomicTravel(AtomicTravel atomicTravel) {
        String q = "from Ticket where atom_travel_id = :e";
        return sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("e", atomicTravel)
                .list().size();
    }

    public boolean checkUserBuyTicket(String f_name, String l_name, Date date, long id) {
        String q = "from Ticket where user_id.last_name = :ln and user_id.first_name = :fn and user_id.birthday = :bd and atom_travel_id.atom_travel_id =:i";
        if (sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("ln", l_name)
                .setParameter("fn", f_name)
                .setParameter("bd", date)
                .setParameter("i", id)
                .list().size() == 0)
            return false;
        else return true;
    }

    public List getTicketByEmail(String email) {
        String q = "from Ticket where user_id.email = :em";
        return sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("em", email)
                .list();
    }

    @Override
    public void saveTicket(Ticket ticket) {
        sessionFactory.getCurrentSession().save(ticket);
    }

    @Override
    public List getTicketByAtomicTravelAndCar(int numCar, AtomicTravel atomicTravel) {
        String q = "from Ticket where numCar = :numCar and atom_travel_id = :atomTravelId order by numTicket";
        return sessionFactory.getCurrentSession().createQuery(q)
                .setParameter("numCar", numCar)
                .setParameter("atomTravelId", atomicTravel)
                .list();
    }
}
