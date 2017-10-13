package com.tsystems.service.api;

import com.tsystems.dto.StationDTO;
import com.tsystems.entity.Station;

import java.util.LinkedList;

public interface StationServiceAPI {


    boolean addStation(Station station);

    LinkedList<String> getListNameStations();

    LinkedList<StationDTO> getListStations();

    boolean checkStation(String station);
}
