package com.tsystems.controller;

import com.tsystems.sender.Sender;
import com.tsystems.service.impl.LineService;
import com.tsystems.service.impl.TrainService;
import com.tsystems.service.impl.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TripController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private LineService lineService;

    @Autowired
    private TripService tripService;

    @PostMapping(path = "/trip/new")
    public ModelAndView viewAddTrip() {
        ModelAndView modelAndView = new ModelAndView("add_trips");
        modelAndView.addObject("trainList", trainService.getNameTrains());
        modelAndView.addObject("lineList", lineService.getNameLines());
        return modelAndView;
    }

    @PostMapping(path = "/trip/add")
    public ModelAndView addTrip(String date_dep, String time_dep, String train, String line) throws ParseException {
        new Sender().send();
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date_dep + " " + time_dep);
        String lines[] = line.split("\\(");
        tripService.saveTrip(date, train, lines[0]);
        ModelAndView modelAndView = new ModelAndView("list_trips");
        modelAndView.addObject("tripList", tripService.getAllTrips());
        return modelAndView;
    }

    @PostMapping(path = "/trip/list")
    public ModelAndView addTrip() {
        ModelAndView modelAndView = new ModelAndView("list_trips");
        modelAndView.addObject("tripList", tripService.getAllTrips());
        return modelAndView;
    }
}
