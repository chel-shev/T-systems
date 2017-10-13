package com.tsystems.dto;

import java.util.Date;

/**
 * Created by user on 07.08.2017.
 */
public class TripDTO {


    private long id;
    private String name;
    private Date date;
    private String train;

    public TripDTO(long id, String name, Date date, String train) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.train = train;
    }

    public TripDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }
}
