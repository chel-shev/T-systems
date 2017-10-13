package com.tsystems.entity;

import javax.persistence.*;

@Entity
@Table(name = "line")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id")
    private long line_id;
    @Column(name = "denotation")
    private String denotation;
    @Column(name = "serial_number")
    private String serial_number;
    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @JoinColumn(name = "station_from", referencedColumnName="station_id")
    private Station station_start_id;
    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @JoinColumn(name = "station_to", referencedColumnName="station_id")
    private Station station_finish_id;
    @Column(name = "removed")
    private boolean removed = false;


    public Line() {
    }

    public Line(String denotation, String serial_number, Station station_start_id, Station station_finish_id, boolean removed) {
        this.denotation = denotation;
        this.serial_number = serial_number;
        this.station_start_id = station_start_id;
        this.station_finish_id = station_finish_id;
        this.removed = removed;
    }

    public long getLine_id() {
        return line_id;
    }

    public void setLine_id(long line_id) {
        this.line_id = line_id;
    }

    public String getDenotation() {
        return denotation;
    }

    public void setDenotation(String denotation) {
        this.denotation = denotation;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Station getStation_start_id() {
        return station_start_id;
    }

    public void setStation_start_id(Station station_start_id) {
        this.station_start_id = station_start_id;
    }

    public Station getStation_finish_id() {
        return station_finish_id;
    }

    public void setStation_finish_id(Station station_finish_id) {
        this.station_finish_id = station_finish_id;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}