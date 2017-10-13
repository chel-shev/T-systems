package com.tsystems.dto.rest;



import java.io.Serializable;
import java.util.Date;

public class ScheduleStationDTO  implements Serializable {

    private String stationDep;
    private String stationArr;
    private Date dateDep;
    private Date dateArr;
    private String denotation;
    private String train;

    public ScheduleStationDTO() {
    }

    public ScheduleStationDTO(String stationDep, String stationArr, Date dateDep, Date dateArr, String denotation, String train) {
        this.stationDep = stationDep;
        this.stationArr = stationArr;
        this.dateDep = dateDep;
        this.dateArr = dateArr;
        this.denotation = denotation;
        this.train = train;
    }

    public String getStationDep() {
        return stationDep;
    }

    public void setStationDep(String stationDep) {
        this.stationDep = stationDep;
    }

    public String getStationArr() {
        return stationArr;
    }

    public void setStationArr(String stationArr) {
        this.stationArr = stationArr;
    }

    public Date getDateDep() {
        return dateDep;
    }

    public void setDateDep(Date dateDep) {
        this.dateDep = dateDep;
    }

    public Date getDateArr() {
        return dateArr;
    }

    public void setDateArr(Date dateArr) {
        this.dateArr = dateArr;
    }

    public String getDenotation() {
        return denotation;
    }

    public void setDenotation(String denotation) {
        this.denotation = denotation;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "ScheduleStationDTO{" +
                "stationDep='" + stationDep + '\'' +
                ", stationArr='" + stationArr + '\'' +
                ", dateDep=" + dateDep +
                ", dateArr=" + dateArr +
                ", denotation='" + denotation + '\'' +
                ", train='" + train + '\'' +
                '}';
    }
}
