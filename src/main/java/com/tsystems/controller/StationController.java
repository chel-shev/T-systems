package com.tsystems.controller;

import com.tsystems.entity.Station;
import com.tsystems.service.impl.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StationController {

    @Autowired
    private StationService stationService;

    @ResponseBody
    @PostMapping(path = "/station/add")
    public ModelAndView addStation(String name_station, String longitude, String latitude) {
        Station station = new Station(name_station, false, new Double(longitude), new Double(latitude));
        System.out.println(name_station + " " + latitude + " " + longitude);
        if (stationService.addStation(station)) {
            ModelAndView modelAndView = new ModelAndView("list_stations");
            modelAndView.addObject("statList", stationService.getListStations());
            return modelAndView;
        }
        return null;
    }

    @PostMapping(path = "/station/new")
    public ModelAndView newStation() {
        return new ModelAndView("add_station");
    }

    @PostMapping(path = "/station/list", produces = {"application/json; charset=UTF-8"})
    public ModelAndView listStation() {
        ModelAndView modelAndView = new ModelAndView("list_stations");
        modelAndView.addObject("statList", stationService.getListStations());
        return modelAndView;
    }
}