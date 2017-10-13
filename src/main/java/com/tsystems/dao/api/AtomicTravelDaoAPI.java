package com.tsystems.dao.api;

import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Line;

import java.util.List;


public interface AtomicTravelDaoAPI {

    void saveTrip(AtomicTravel atomicTravel);

    List getAllAtomicTravel();

    List getAtomicTravelByLine(Line line);

    AtomicTravel getAtomicTravelById(long id);
}
