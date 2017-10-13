package com.tsystems.service.impl;

import com.tsystems.dao.api.AtomicTravelDaoAPI;
import com.tsystems.dao.api.StageDaoAPI;
import com.tsystems.dto.SearchDTO;
import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Line;
import com.tsystems.entity.Stage;
import com.tsystems.service.api.SearchServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SearchService implements SearchServiceAPI {

    @Autowired
    private StageDaoAPI stageDao;

    @Autowired
    private AtomicTravelDaoAPI atomicTravelDao;

    public LinkedList<SearchDTO> getResultSearch(String from, String to, String from_date, String to_date) {
        Date date_from = null;
        Date date_to = null;
        try {
            date_from = new SimpleDateFormat("yyyy-MM-dd").parse(from_date);
            date_to = new SimpleDateFormat("yyyy-MM-dd").parse(to_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LinkedList<SearchDTO> listDTO = new LinkedList<SearchDTO>();
        @SuppressWarnings("unchecked")
        List<Stage> listStage = (List<Stage>) (List<?>) stageDao.getFromStageByName(from);
        for (Stage stage : listStage) {
            Line line = stage.getLine_id();
            Stage stage_online = stageDao.getStageByNameAndLine(to, line);
            if (stage_online == null) {
                continue;
            }
            if (stage.getNumber() > stage_online.getNumber()) {
                continue;
            }
            @SuppressWarnings("unchecked")
            List<AtomicTravel> listAtomicTravel = (List<AtomicTravel>) (List<?>) atomicTravelDao.getAtomicTravelByLine(line);
            for (AtomicTravel atomicTravel : listAtomicTravel) {
                if (atomicTravel == null) {
                    continue;
                }
                if (milliToMinutes(new Date().getTime()) + 10 >= (milliToMinutes(atomicTravel.getDeparture_time().getTime()))) {
                    continue;
                }
                if (atomicTravel.getDeparture_time().getTime() < date_from.getTime() || atomicTravel.getDeparture_time().getTime() > date_to.getTime()){
                    continue;
                }
                SearchDTO searchDTO = new SearchDTO();
                searchDTO.setAtomicTravel(line.getDenotation());
                searchDTO.setTrain(atomicTravel.getTrain_id().getName());
                searchDTO.setDate_from(atomicTravel.getDeparture_time());
                Date date = new Date(atomicTravel.getDeparture_time().getTime() + stage_online.getFrom_start());
                searchDTO.setDate_to(date);
                searchDTO.setId(String.valueOf(atomicTravel.getAtom_travel_id()) + "_" + from + "_" + to);
                searchDTO.setFrom(from);
                searchDTO.setTo(to);
                listDTO.add(searchDTO);
            }
        }
        return listDTO;
    }


    private long milliToMinutes(long milli) {
        return ((milli / 1000) / 60);
    }
}