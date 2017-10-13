package com.tsystems.dao.api;

import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Ticket;
import com.tsystems.entity.User;

import java.util.Date;
import java.util.List;

public interface TicketDaoAPI {


    void buyTicket(User user, AtomicTravel atomicTravel, int numSit, int numCar , String form, String to);

    long getTicketByAtomicTravel(AtomicTravel atomicTravel);

    boolean checkUserBuyTicket(String f_name, String l_name, Date date, long id);

    List getTicketByEmail(String email);

    void saveTicket(Ticket ticket);

    List getTicketByAtomicTravelAndCar(int numCar, AtomicTravel numAtomicTravel);
}
