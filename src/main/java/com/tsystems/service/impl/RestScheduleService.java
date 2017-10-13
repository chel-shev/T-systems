package com.tsystems.service.impl;

import com.tsystems.dao.api.AtomicTravelDaoAPI;
import com.tsystems.dao.api.StageDaoAPI;
import com.tsystems.dao.api.StationDaoAPI;
import com.tsystems.dao.impl.StageDao;
import com.tsystems.dao.impl.StationDao;
import com.tsystems.dto.ScheduleDTO;
import com.tsystems.dto.rest.ListScheduleStationDTO;
import com.tsystems.dto.rest.ScheduleStationDTO;
import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Line;
import com.tsystems.entity.Stage;
import com.tsystems.service.api.RestScheduleServiceAPI;
import com.tsystems.service.api.ScheduleServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class RestScheduleService implements RestScheduleServiceAPI {

    @Autowired
    private StationDaoAPI stationDao;

    @Autowired
    private StageDaoAPI stageDao;

    @Autowired
    private AtomicTravelDaoAPI atomicTravelDao;

    @Override
    public ListScheduleStationDTO getSchedule(String id) {
        String station = stationDao.getStationById(new Long(id)).getName();
        ListScheduleStationDTO listScheduleStationDTO = new ListScheduleStationDTO();
        @SuppressWarnings("unchecked")
        List<Stage> listToStage = (List<Stage>) (List<?>) stageDao.getToStageByName(station);
        for (Stage stage : listToStage) {
            Line line = stage.getLine_id();
            @SuppressWarnings("unchecked")
            List<AtomicTravel> listAtomicTravel = (List<AtomicTravel>) (List<?>) atomicTravelDao.getAtomicTravelByLine(line);
            for (AtomicTravel atomicTravel : listAtomicTravel) {
                ScheduleStationDTO scheduleStationDTO = new ScheduleStationDTO();
                Date date = new Date(atomicTravel.getDeparture_time().getTime() + stage.getFrom_start());
                scheduleStationDTO.setDenotation(line.getDenotation());
                scheduleStationDTO.setStationDep(line.getStation_start_id().getName());
                scheduleStationDTO.setStationArr(station);
                scheduleStationDTO.setDateDep(atomicTravel.getDeparture_time());
                scheduleStationDTO.setDateArr(date);
                scheduleStationDTO.setTrain(atomicTravel.getTrain_id().getName());
                listScheduleStationDTO.add(scheduleStationDTO);
            }
        }
        @SuppressWarnings("unchecked")
        List<Stage> listFromStage = (List<Stage>) (List<?>) stageDao.getFromStageByName(station);
        for (Stage stage : listFromStage) {
            if (stage.getNumber() == 1) {
                Line line = stage.getLine_id();
                @SuppressWarnings("unchecked")
                List<AtomicTravel> listAtomicTravel = (List<AtomicTravel>) (List<?>) atomicTravelDao.getAtomicTravelByLine(line);
                for (AtomicTravel atomicTravel : listAtomicTravel) {
                    listScheduleStationDTO.add(new ScheduleStationDTO(line.getStation_start_id().getName(),
                            station, atomicTravel.getDeparture_time(),
                            atomicTravel.getDeparture_time(), line.getDenotation(),
                            atomicTravel.getTrain_id().getName()));
                }
            }
        }
        return listScheduleStationDTO;
    }
}
