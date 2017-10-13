package com.tsystems.controller;

import com.tsystems.dto.rest.ListScheduleStationDTO;
import com.tsystems.service.api.RestScheduleServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestScheduleController {

    @Autowired
    private RestScheduleServiceAPI restScheduleService;

    @GetMapping(path = "/rest/schedule/{id}", produces = {"application/json; charset=UTF-8"})
    public ListScheduleStationDTO search(@PathVariable("id") int id) {
        return restScheduleService.getSchedule(String.valueOf(id));
    }
}
