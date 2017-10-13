package com.tsystems.controller;

import com.tsystems.entity.AtomicTravel;
import com.tsystems.entity.Train;
import com.tsystems.service.impl.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;

@Controller
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping(path = "/train/add")
    public ModelAndView addTrain(String seats, String name) {
        Train train = new Train((long) new Integer(seats), false, name, new HashSet<AtomicTravel>());
        if (trainService.addTrain(train)) {
            ModelAndView modelAndView = new ModelAndView("list_trains");
            modelAndView.addObject("trainList", trainService.getListTrains());
            return modelAndView;
        }
        return null;
    }

    @PostMapping(path = "/train/new")
    public ModelAndView newTrain() {
        return new ModelAndView("add_train");
    }


    @PostMapping(path = "/train/list", produces = {"application/json; charset=UTF-8"})
    public ModelAndView listTrain() {
        ModelAndView modelAndView = new ModelAndView("list_trains");
        modelAndView.addObject("trainList", trainService.getListTrains());
        return modelAndView;
    }
}
