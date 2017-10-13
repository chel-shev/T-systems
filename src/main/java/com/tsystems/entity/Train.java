package com.tsystems.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private long train_id;
    @Column(name = "sits_count")
    private long sits_count;
    @Column(name = "removed")
    private boolean removed = false;
    @Column(name = "name")
    private String name;

    public Train() {
    }

    public Train(long sits_count, boolean removed, String name, Set<AtomicTravel> atom_travel_id) {
        this.sits_count = sits_count;
        this.removed = removed;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }


    public long getTrain_id() {
        return train_id;
    }

    public void setTrain_id(long train_id) {
        this.train_id = train_id;
    }

    public long getSits_count() {
        return sits_count;
    }

    public void setSits_count(long sits_count) {
        this.sits_count = sits_count;
    }
}
