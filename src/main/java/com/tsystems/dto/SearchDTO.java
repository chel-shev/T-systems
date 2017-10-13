package com.tsystems.dto;

import java.util.Date;

/**
 * Created by user on 09.08.2017.
 */
public class SearchDTO {

    private String from;
    private String to;
    private String atomicTravel;
    private String train;
    private Date date_from;
    private Date date_to;
    private String id;
    private boolean buy;

    public SearchDTO() {
    }

    public SearchDTO(String from, String to, String atomicTravel, String train, Date date_from, Date date_to, String id, boolean buy) {
        this.from = from;
        this.to = to;
        this.atomicTravel = atomicTravel;
        this.train = train;
        this.date_from = date_from;
        this.date_to = date_to;
        this.id = id;
        this.buy = buy;
    }

    public String getAtomicTravel() {
        return atomicTravel;
    }

    public void setAtomicTravel(String atomicTravel) {
        this.atomicTravel = atomicTravel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }
}
