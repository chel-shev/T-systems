package com.tsystems.dto;

import java.util.Date;

public class TicketDTO {

    private String from;
    private String to;
    private String denotation;
    private Date date_arr;
    private Date date_dep;
    private int sit;
    private int car;
    private String img;

    public TicketDTO() {
    }

    public TicketDTO(String from, String to, String denotation, Date date_arr, Date date_dep, int sit, int car) {
        this.from = from;
        this.to = to;
        this.denotation = denotation;
        this.date_arr = date_arr;
        this.date_dep = date_dep;
        this.sit = sit;
        this.car = car;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getSit() {
        return sit;
    }

    public void setSit(int sit) {
        this.sit = sit;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
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

    public String getDenotation() {
        return denotation;
    }

    public void setDenotation(String denotation) {
        this.denotation = denotation;
    }

    public Date getDate_arr() {
        return date_arr;
    }

    public void setDate_arr(Date date_arr) {
        this.date_arr = date_arr;
    }

    public Date getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(Date date_dep) {
        this.date_dep = date_dep;
    }
}
