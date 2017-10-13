package com.tsystems.service.api;

import com.tsystems.dto.ScheduleDTO;

import java.util.LinkedList;

public interface ScheduleServiceAPI {

    LinkedList<ScheduleDTO> getSchedule(String station, String from_date, String to_date);
}
