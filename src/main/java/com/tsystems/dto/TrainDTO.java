package com.tsystems.dto;


/**
 * Created by user on 10.08.2017.
 */
public class TrainDTO {

    private long sits_count;
    private String name;


    public TrainDTO(String name, long sits_count) {
        this.sits_count = sits_count;
        this.name = name;
    }

    public long getSits_count() {
        return sits_count;
    }

    public void setSits_count(long sits_count) {
        this.sits_count = sits_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
