package com.tsystems.service.api;

import com.tsystems.dto.TripDTO;

import java.util.Date;
import java.util.LinkedList;

public interface TripServiceAPI {

    void saveTrip(Date date, String train_str, String line_str);

    LinkedList<TripDTO> getAllTrips();
}
