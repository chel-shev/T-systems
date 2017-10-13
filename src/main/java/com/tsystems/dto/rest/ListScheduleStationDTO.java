package com.tsystems.dto.rest;

import java.io.Serializable;
import java.util.LinkedList;

public class ListScheduleStationDTO  implements Serializable {

    private LinkedList<ScheduleStationDTO> scheduleStationDTOS;

    public ListScheduleStationDTO() {
        scheduleStationDTOS = new LinkedList<>();
    }

    public ListScheduleStationDTO(LinkedList<ScheduleStationDTO> scheduleStationDTOS) {
        this.scheduleStationDTOS = scheduleStationDTOS;
    }

    public LinkedList<ScheduleStationDTO> getScheduleStationDTOS() {
        return scheduleStationDTOS;
    }

    public void setScheduleStationDTOS(LinkedList<ScheduleStationDTO> scheduleStationDTOS) {
        this.scheduleStationDTOS = scheduleStationDTOS;
    }

    public void add(ScheduleStationDTO scheduleStationDTO){
        scheduleStationDTOS.add(scheduleStationDTO);
    }
}
