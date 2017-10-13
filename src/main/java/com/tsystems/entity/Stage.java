package com.tsystems.entity;

import javax.persistence.*;

@Entity
@Table(name = "stage")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stage_id")
    private long stage_id;
    @Column(name = "range")
    private double range;
    @Column(name = "removed")
    private boolean removed = false;
    @Column(name = "number")
    private int number;
    @Column(name = "from_start")
    private long from_start;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fr_station_id", referencedColumnName = "station_id")
    private Station from_station_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "t_station_id", referencedColumnName = "station_id")
    private Station to_station_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "line_id")
    private Line line_id;

    public Stage() {
    }

    public Stage(double range, boolean removed, int number, long from_start, Station from_station_id, Station to_station_id, Line line_id) {
        this.range = range;
        this.removed = removed;
        this.number = number;
        this.from_start = from_start;
        this.from_station_id = from_station_id;
        this.to_station_id = to_station_id;
        this.line_id = line_id;
    }

    public long getFrom_start() {
        return from_start;
    }

    public void setFrom_start(long from_start) {
        this.from_start = from_start;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }


    public long getStage_id() {
        return stage_id;
    }

    public void setStage_id(long stage_id) {
        this.stage_id = stage_id;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public Station getFrom_station_id() {
        return from_station_id;
    }

    public void setFrom_station_id(Station from_station_id) {
        this.from_station_id = from_station_id;
    }

    public Station getTo_station_id() {
        return to_station_id;
    }

    public void setTo_station_id(Station to_station_id) {
        this.to_station_id = to_station_id;
    }

    public Line getLine_id() {
        return line_id;
    }

    public void setLine_id(Line line_id) {
        this.line_id = line_id;
    }
}
