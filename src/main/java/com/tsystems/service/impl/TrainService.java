package com.tsystems.service.impl;

import com.tsystems.dao.api.TrainDaoAPI;
import com.tsystems.dto.TrainDTO;
import com.tsystems.entity.Train;
import com.tsystems.service.api.TrainServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TrainService implements TrainServiceAPI{

    @Autowired
    private TrainDaoAPI trainDao;

    public boolean addTrain(Train train) {
        return trainDao.addTrain(train);
    }

    public LinkedList<String> getNameTrains() {
        List list = trainDao.getAllTrains();
        LinkedList<String> linkedList = new LinkedList<String>();
        for (Object object : list) {
            Train station = (Train) object;
            linkedList.add(station.getName());
        }
        return linkedList;
    }

    public LinkedList<TrainDTO> getListTrains() {
        List list = trainDao.getAllTrains();
        LinkedList<TrainDTO> linkedList = new LinkedList<TrainDTO>();
        for (Object object : list) {
            Train station = (Train) object;
            linkedList.add(new TrainDTO(station.getName(), station.getSits_count()));
        }
        return linkedList;
    }
}
