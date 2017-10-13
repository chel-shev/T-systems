package com.tsystems.service.impl;

import com.tsystems.dao.api.AtomicTravelDaoAPI;
import com.tsystems.dao.api.LineDaoAPI;
import com.tsystems.dao.api.TicketDaoAPI;
import com.tsystems.dao.api.TrainDaoAPI;
import com.tsystems.dto.TripDTO;
import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Line;
import com.tsystems.entity.Ticket;
import com.tsystems.entity.Train;
import com.tsystems.service.api.TripServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by user on 07.08.2017.
 */
@Service
public class TripService implements TripServiceAPI{

    @Autowired
    private TrainDaoAPI trainDao;

    @Autowired
    private AtomicTravelDaoAPI atomicTravelDao;

    @Autowired
    private LineDaoAPI lineDao;

    @Autowired
    private TicketDaoAPI ticketDao;

    public void saveTrip(Date date, String train_str, String line_str) {
        Train train = trainDao.getTrainByName(train_str);
        long numCarSize = train.getSits_count();
        Line line = lineDao.getLineByName(line_str);
        AtomicTravel atomicTravel = new AtomicTravel(date, train, line, false);
        atomicTravelDao.saveTrip(atomicTravel);
        for(int numCar = 1; numCar <= numCarSize; numCar++) {
            for (int numTicket = 1; numTicket <= 32; numTicket++) {
                Ticket ticket = new Ticket(null, null, numTicket, numCar, false, null, atomicTravel);
                ticketDao.saveTicket(ticket);
            }
        }
    }

    public LinkedList<TripDTO> getAllTrips() {
        @SuppressWarnings("unchecked")
        List<AtomicTravel> allAtomicTravel = (List<AtomicTravel>)(List<?>)atomicTravelDao.getAllAtomicTravel();
        LinkedList<TripDTO> list = new LinkedList<TripDTO>();
        for(AtomicTravel atomicTravel: allAtomicTravel){
            TripDTO tripDTO = new TripDTO();
            tripDTO.setName(atomicTravel.getLine_id().getDenotation()
                    + "(" + atomicTravel.getLine_id().getSerial_number() + ")");
            tripDTO.setDate(atomicTravel.getDeparture_time());
            tripDTO.setTrain(atomicTravel.getTrain_id().getName());
            tripDTO.setId(atomicTravel.getAtom_travel_id());
            list.add(tripDTO);
        }
        return list;
    }
}
