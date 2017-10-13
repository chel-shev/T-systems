package com.tsystems.service.impl;

import com.tsystems.dao.api.AtomicTravelDaoAPI;
import com.tsystems.dao.api.StageDaoAPI;
import com.tsystems.dto.ScheduleDTO;

import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Line;
import com.tsystems.entity.Stage;
import com.tsystems.service.api.ScheduleServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
class ScheduleService implements ScheduleServiceAPI {

    @Autowired
    private StageDaoAPI stageDao;

    @Autowired
    private AtomicTravelDaoAPI atomicTravelDao;

    public LinkedList<ScheduleDTO> getSchedule(String station, String from_date, String to_date) {
        Date date_from = null;
        Date date_to = null;
        try {
            date_from = new SimpleDateFormat("yyyy-MM-dd").parse(from_date);
            date_to = new SimpleDateFormat("yyyy-MM-dd").parse(to_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LinkedList<ScheduleDTO> scheduleList = new LinkedList<ScheduleDTO>();
        @SuppressWarnings("unchecked")
        List<Stage> listToStage = (List<Stage>) (List<?>) stageDao.getToStageByName(station);
        for (Stage stage : listToStage) {
            Line line = stage.getLine_id();
            @SuppressWarnings("unchecked")
            List<AtomicTravel> listAtomicTravel = (List<AtomicTravel>) (List<?>) atomicTravelDao.getAtomicTravelByLine(line);
            for (AtomicTravel atomicTravel : listAtomicTravel) {
                if (atomicTravel.getDeparture_time().getTime() < date_from.getTime() || atomicTravel.getDeparture_time().getTime() > date_to.getTime()) {
                    continue;
                }
                ScheduleDTO scheduleDTO = new ScheduleDTO();
                Date date = new Date(atomicTravel.getDeparture_time().getTime() + stage.getFrom_start());
                scheduleDTO.setName(line.getDenotation());
                scheduleDTO.setStation_from(line.getStation_start_id().getName());
                scheduleDTO.setStation_to(station);
                scheduleDTO.setDateDep(atomicTravel.getDeparture_time());
                scheduleDTO.setDateIn(date);
                scheduleDTO.setTrain(atomicTravel.getTrain_id().getName());
                scheduleList.add(scheduleDTO);
            }
        }
        @SuppressWarnings("unchecked")
        List<Stage> listFromStage = (List<Stage>) (List<?>) stageDao.getFromStageByName(station);
        for (Stage stage : listFromStage) {
            if (stage.getNumber() != 1) {
                continue;
            }
            Line line = stage.getLine_id();
            @SuppressWarnings("unchecked")
            List<AtomicTravel> listAtomicTravel = (List<AtomicTravel>) (List<?>) atomicTravelDao.getAtomicTravelByLine(line);
            for (AtomicTravel atomicTravel : listAtomicTravel) {
                if (atomicTravel.getDeparture_time().getTime() < date_from.getTime() || atomicTravel.getDeparture_time().getTime() > date_to.getTime()) {
                    continue;
                }
                scheduleList.add(new ScheduleDTO(line.getDenotation(), atomicTravel.getDeparture_time(),
                        atomicTravel.getDeparture_time(), line.getStation_start_id().getName(), station,
                        atomicTravel.getTrain_id().getName()));
            }

        }
        return scheduleList;
    }
}