package com.tsystems.dto;

import java.util.Date;

/**
 * Created by user on 10.08.2017.
 */
public class ScheduleDTO {


    private String name;
    private Date dateDep;
    private Date dateIn;
    private String station_from;
    private String station_to;
    private String train;

    public ScheduleDTO() {
    }

    public ScheduleDTO(String name, Date dateDep, Date dateIn, String station_from, String station_to, String train) {
        this.name = name;
        this.dateDep = dateDep;
        this.dateIn = dateIn;
        this.station_from = station_from;
        this.station_to = station_to;
        this.train = train;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateDep() {
        return dateDep;
    }

    public void setDateDep(Date dateDep) {
        this.dateDep = dateDep;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public String getStation_from() {
        return station_from;
    }

    public void setStation_from(String station_from) {
        this.station_from = station_from;
    }

    public String getStation_to() {
        return station_to;
    }

    public void setStation_to(String station_to) {
        this.station_to = station_to;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }
}
