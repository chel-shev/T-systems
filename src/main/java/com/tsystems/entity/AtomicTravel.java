package com.tsystems.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "atom_travel")
public class AtomicTravel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atom_travel_id")
    private long atom_travel_id;
    @Column(name = "departure_time")
    private Date departure_time;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "train_id")
    private Train train_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "line_id")
    private Line line_id;
    @Column(name = "removed")
    private boolean removed = false;

    public AtomicTravel() {
    }

    public AtomicTravel(Date departure_time, Train train_id, Line line_id, boolean removed) {
        this.departure_time = departure_time;
        this.train_id = train_id;
        this.line_id = line_id;
        this.removed = removed;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }


    public long getAtom_travel_id() {
        return atom_travel_id;
    }

    public void setAtom_travel_id(long atom_travel_id) {
        this.atom_travel_id = atom_travel_id;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public Train getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Train train_id) {
        this.train_id = train_id;
    }

    public Line getLine_id() {
        return line_id;
    }

    public void setLine_id(Line line_id) {
        this.line_id = line_id;
    }
}
