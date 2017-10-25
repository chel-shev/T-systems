package com.tsystems.service.impl;

import com.tsystems.dao.api.StationDaoAPI;
import com.tsystems.dto.StationDTO;
import com.tsystems.entity.Station;
import com.tsystems.service.api.StationServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 06.08.2017.
 */
@Service
public class StationService implements StationServiceAPI {

    @Autowired
    private StationDaoAPI stationDao;

    public boolean addStation(Station station) {
        return stationDao.addStation(station);
    }

    public LinkedList<String> getListNameStations() {
        List list = stationDao.getAllStation();
        LinkedList<String> linkedList = new LinkedList<String>();
        for (Object object : list) {
            Station station = (Station) object;
            linkedList.add(station.getName());
        }
        return linkedList;
    }

    public LinkedList<StationDTO> getListStations() {
        List list = stationDao.getAllStation();
        LinkedList<StationDTO> linkedList = new LinkedList<StationDTO>();
        for(Object object: list){
            Station station = (Station) object;
            linkedList.add(new StationDTO(station.getName(), station.getLongitude(), station.getLatitude()));
        }
        return linkedList;
    }

    public boolean checkStation(String station) {
        if (stationDao.getStationByName(station) == null) {
            return false;
        } else {
            return true;
        }
    }
}
