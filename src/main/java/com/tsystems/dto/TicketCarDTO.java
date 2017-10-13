package com.tsystems.dto;

import java.util.LinkedList;

public class TicketCarDTO {

    private long numCar;
    private LinkedList<String> info;
    private String numAtomic;

    public TicketCarDTO() {
    }

    public TicketCarDTO(long numCar, LinkedList<String> info, String numAtomic) {
        this.numCar = numCar;
        this.info = info;
        this.numAtomic = numAtomic;
    }

    public long getNumCar() {
        return numCar;
    }

    public void setNumCar(long numCar) {
        this.numCar = numCar;
    }

    public LinkedList<String> getInfo() {
        return info;
    }

    public void setInfo(LinkedList<String> info) {
        this.info = info;
    }

    public String getNumAtomic() {
        return numAtomic;
    }

    public void setNumAtomic(String numAtomic) {
        this.numAtomic = numAtomic;
    }
}
