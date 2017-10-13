package com.tsystems.service.impl;

import com.tsystems.dao.api.LineDaoAPI;
import com.tsystems.dao.api.StageDaoAPI;
import com.tsystems.dao.api.StationDaoAPI;
import com.tsystems.dto.LineDTO;
import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Line;
import com.tsystems.entity.Stage;
import com.tsystems.entity.Station;
import com.tsystems.service.api.LineServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.*;

@Service
public class LineService implements LineServiceAPI {

    private static final double EARTH_RADIUS = 6371.;

    @Autowired
    private LineDaoAPI lineDao;

    @Autowired
    private StationDaoAPI stationDao;

    @Autowired
    private StageDaoAPI stageDao;

    private LinkedList<String> getListStationFromLine(Line line) {
        LinkedList<String> stations = new LinkedList<String>();
        @SuppressWarnings("unchecked")
        List<Stage> allStages = (List<Stage>) (List<?>) stageDao.getStageByLineId(line);
        for (Stage stage : allStages) {
            if (!stations.contains(stage.getFrom_station_id().getName())) {
                stations.add(stage.getFrom_station_id().getName());
            }
            if (!stations.contains(stage.getTo_station_id().getName())) {
                stations.add(stage.getTo_station_id().getName());
            }
        }
        return stations;
    }

    public LinkedList<LineDTO> getListStations() {
        LinkedList<LineDTO> lineDTOS = new LinkedList<LineDTO>();
        HashMap<String, LinkedList<String>> lines = new HashMap<String, LinkedList<String>>();

        @SuppressWarnings("unchecked")
        List<Line> allLines = (List<Line>) (List<?>) lineDao.getAllLines();

        for (Line line : allLines) {
            LineDTO lineDTO = new LineDTO();
            String line_name = line.getDenotation() + " (" + line.getSerial_number() + ")";
            lineDTO.setName(line_name);
            LinkedList<String> stations = getListStationFromLine(line);
            lineDTO.setTrips(stations);
            lineDTOS.add(lineDTO);
        }
        return lineDTOS;
    }

    public LinkedList<String> getNameLines() {
        @SuppressWarnings("unchecked")
        List<Line> allLines = (List<Line>) (List<?>) lineDao.getAllLines();
        LinkedList<String> nameLines = new LinkedList<String>();
        for(Line line: allLines){
            nameLines.add(line.getDenotation() + "(" + line.getSerial_number() + ")");
        }
        return nameLines;
    }

    public void addLine(String line_str) {
        String[] lineArray = line_str.split(",");
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(Arrays.asList(lineArray));
        ListIterator listIterator = linkedList.listIterator();
        String start = (String) linkedList.getFirst();
        String finish = (String) linkedList.getLast();
        Station startStation = stationDao.getStationByName(start);
        Station finishStation = stationDao.getStationByName(finish);
        String name = start + "-" + finish;
        long lineNumber = lineDao.getLastNumber();
        long time = 0;
        String number = "M" + (1000 + lineNumber);
        Line line = new Line(name, number, startStation, finishStation, false);
        if (lineDao.saveLine(line)) {
            int count = 1;
            Line lineSave = lineDao.getLineByName(line.getDenotation());
            String toStation;
            String fromStation = (String) listIterator.next();
            while (listIterator.hasNext()) {
                toStation = (String) listIterator.next();
                Station from_s = stationDao.getStationByName(fromStation);
                Station to_s = stationDao.getStationByName(toStation);
                Double range = rangeCalc(from_s.getLongitude(), from_s.getLatitude(), to_s.getLongitude(), to_s.getLatitude());
                time = (long) ((range / 0.0222222) * 1000) + time;
                Stage stage = new Stage(range, false, count++, time, from_s, to_s, lineSave);
                stageDao.saveStage(stage);
                fromStation = toStation;
            }
        }
    }

    private double rangeCalc(double lng, double lat, double lng1, double lat1) {
        final double dlng = deg2rad(lng - lng1);
        final double dlat = deg2rad(lat - lat1);
        final double a = sin(dlat / 2) * sin(dlat / 2) + cos(deg2rad(lat))
                * cos(deg2rad(lat1)) * sin(dlng / 2) * sin(dlng / 2);
        final double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return c * EARTH_RADIUS;
    }

    private static double deg2rad(final double degree) {
        return degree * (Math.PI / 180);
    }


}
