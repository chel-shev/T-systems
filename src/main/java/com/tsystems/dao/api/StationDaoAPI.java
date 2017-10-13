package com.tsystems.dao.api;

import com.tsystems.entity.Station;

import java.util.List;

public interface StationDaoAPI {

    boolean addStation(Station station);

    List getAllStation();

    Station getStationByName(String name);

    Station getStationById(Long id);
}
