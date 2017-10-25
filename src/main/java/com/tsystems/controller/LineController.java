package com.tsystems.controller;

import com.tsystems.service.impl.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LineController {

    @Autowired
    private LineService lineService;

    @PostMapping(path = "/line/add")
    public ModelAndView addLine(String line) {

        lineService.addLine(line);
        ModelAndView modelAndView = new ModelAndView("list_line");
        modelAndView.addObject("lineList", lineService.getListStations());
        return modelAndView;
    }

    @PostMapping(path = "/line/new")
    public ModelAndView newLine() {
        return new ModelAndView("add_line");
    }

    @PostMapping(path = "/line/list")
    public ModelAndView listLine() {
        ModelAndView modelAndView = new ModelAndView("list_line");
        modelAndView.addObject("lineList", lineService.getListStations());
        return modelAndView;
    }

}


