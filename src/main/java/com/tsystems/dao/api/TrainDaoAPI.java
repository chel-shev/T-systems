package com.tsystems.dao.api;

import com.tsystems.entity.Train;

import java.util.List;

public interface TrainDaoAPI {

    boolean addTrain(Train train);

    List getAllTrains();

    Train getTrainByName(String train_str);
}
