package com.tsystems.service.api;

import com.tsystems.dto.rest.ListScheduleStationDTO;


public interface RestScheduleServiceAPI {

    ListScheduleStationDTO getSchedule(String station);
}
