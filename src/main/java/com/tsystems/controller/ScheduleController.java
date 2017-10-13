package com.tsystems.controller;

import com.tsystems.service.api.ScheduleServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleServiceAPI scheduleService;

    @PostMapping(path = "/schedule")
    public ModelAndView schedule() {
        return new ModelAndView("user_schedule");
    }

    @PostMapping(path = "/schedule/result")
    public ModelAndView scheduleResult(String station, String from_date, String to_date) {
        ModelAndView modelAndView = new ModelAndView("show_schedule");
        modelAndView.addObject("scheduleList", scheduleService.getSchedule(station, from_date, to_date));
        return modelAndView;
    }
}
