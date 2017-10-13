package com.tsystems.dto;

import java.util.HashMap;
import java.util.LinkedList;

public class LineDTO {

    private String name;
    private LinkedList<String> trips;

    public LineDTO(){

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<String> getTrips() {
        return trips;
    }

    public void setTrips(LinkedList<String> trips) {
        this.trips = trips;
    }


}
