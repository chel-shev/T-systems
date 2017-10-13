package com.tsystems.service.api;

import com.tsystems.dto.TrainDTO;
import com.tsystems.entity.Train;

import java.util.LinkedList;

public interface TrainServiceAPI {

    boolean addTrain(Train train);

    LinkedList<String> getNameTrains();

    LinkedList<TrainDTO> getListTrains();
}
