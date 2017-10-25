package com.tsystems.service.impl;

import com.tsystems.bean.UserBean;
import com.tsystems.dao.api.AtomicTravelDaoAPI;
import com.tsystems.dao.api.StageDaoAPI;
import com.tsystems.dao.api.TicketDaoAPI;
import com.tsystems.dao.api.UserDaoAPI;
import com.tsystems.dao.impl.StageDao;
import com.tsystems.dto.TicketCarDTO;
import com.tsystems.dto.TicketDTO;
import com.tsystems.entity.*;
import com.tsystems.service.api.TicketServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class TicketService implements TicketServiceAPI {

    @Autowired
    private UserDaoAPI userDao;

    @Autowired
    private AtomicTravelDaoAPI atomicTravelDao;

    @Autowired
    private TicketDaoAPI ticketDao;

    @Autowired
    private StageDaoAPI stageDao;

    public boolean buyTicket(UserBean userBean, String id, String numSit) {
        String[] data = id.split("_");
        String[] ticket_info = numSit.split("_");
        User user = userDao.getUserByEmail(userBean.getEmail());
        long id_atomic = new Long(data[0]);
        AtomicTravel atomicTravel = atomicTravelDao.getAtomicTravelById(id_atomic);
        if (milliToMinutes(new Date().getTime()) + 10 > (milliToMinutes(atomicTravel.getDeparture_time().getTime())))
            return false;
        else if (ticketDao.checkUserBuyTicket(user.getFirst_name(), user.getLast_name(), user.getBirthday(), id_atomic))
            return false;
        else
            ticketDao.buyTicket(user, atomicTravel, new Integer(ticket_info[0]), new Integer(ticket_info[1]), data[1], data[2]);
        return true;
    }

    public LinkedList<TicketDTO> getTicket(String email) {
        LinkedList<TicketDTO> list = new LinkedList<TicketDTO>();
        List list1 = ticketDao.getTicketByEmail(email);
        for (Object o : list1) {
            TicketDTO ticketDTO = new TicketDTO();
            Ticket ticket = (Ticket) o;
            ticketDTO.setDenotation(ticket.getAtom_travel_id().getLine_id().getDenotation());
            ticketDTO.setDate_dep(ticket.getAtom_travel_id().getDeparture_time());
            AtomicTravel atomicTravel = ticket.getAtom_travel_id();
            Line line = atomicTravel.getLine_id();
            Stage stage = stageDao.getStageByNameAndLine(ticket.getS_to(), line);
            Date date = new Date(ticket.getAtom_travel_id().getDeparture_time().getTime() + stage.getFrom_start());
            ticketDTO.setDate_arr(date);
            ticketDTO.setFrom(ticket.getS_from());
            ticketDTO.setTo(ticket.getS_to());
            ticketDTO.setCar(ticket.getNumCar());
            ticketDTO.setSit(ticket.getNumTicket());
            ticketDTO.setImg("img" + (new Random().nextInt(6) + 1));
            list.add(ticketDTO);
        }
        return list;
    }

    @Override
    public LinkedList<TicketCarDTO> getListTicket(String id) {
        LinkedList<TicketCarDTO> listTicket = new LinkedList<>();
        AtomicTravel atomicTravel1 = atomicTravelDao.getAtomicTravelById(new Long(id.split("_")[0]));
        int numCarSize = (int) atomicTravel1.getTrain_id().getSits_count();
        for (int numCar = 1; numCar <= numCarSize; numCar++) {
            TicketCarDTO ticketCarDTO = new TicketCarDTO();
            ticketCarDTO.setNumCar(numCar);
            ticketCarDTO.setInfo(getCar(numCar, atomicTravel1));
            ticketCarDTO.setNumAtomic(id);
            listTicket.add(ticketCarDTO);
        }
        return listTicket;
    }

    private LinkedList<String> getCar(int numCar, AtomicTravel AtomicTravel) {
        @SuppressWarnings("unchecked")
        List<Ticket> allTicketCar = (List<Ticket>) (List<?>) ticketDao.getTicketByAtomicTravelAndCar(numCar, AtomicTravel);
        LinkedList<String> listTicket = new LinkedList<>();
        listTicket.add("");
        for (Ticket ticket : allTicketCar) {
            if (ticket.getUser_id() == null) {
                listTicket.add(ticket.getNumTicket(), null);
            } else {
                listTicket.add(ticket.getNumTicket(), ticket.getUser_id().getFirst_name() + " " + ticket.getUser_id().getLast_name());
            }
        }
        return listTicket;
    }

    private long milliToMinutes(long milli) {
        return ((milli / 1000) / 60);
    }
}