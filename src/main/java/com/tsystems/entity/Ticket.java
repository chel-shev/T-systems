package com.tsystems.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private long ticket_id;
    @Column(name = "s_from")
    private String s_from;
    @Column(name = "s_to")
    private String s_to;
    @Column(name = "num_ticket")
    private int numTicket;
    @Column(name = "num_car")
    private int numCar;
    @Column(name = "removed")
    private boolean removed = false;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "atom_travel_id")
    private AtomicTravel atom_travel_id;

    public Ticket() {
    }

    public Ticket(String s_from, String s_to, int numTicket, int numCar, boolean removed, User user_id, AtomicTravel atom_travel_id) {
        this.s_from = s_from;
        this.s_to = s_to;
        this.numTicket = numTicket;
        this.numCar = numCar;
        this.removed = removed;
        this.user_id = user_id;
        this.atom_travel_id = atom_travel_id;
    }

    public String getS_from() {
        return s_from;
    }

    public void setS_from(String s_from) {
        this.s_from = s_from;
    }

    public String getS_to() {
        return s_to;
    }

    public void setS_to(String s_to) {
        this.s_to = s_to;
    }

    public AtomicTravel getAtom_travel_id() {
        return atom_travel_id;
    }

    public void setAtom_travel_id(AtomicTravel atom_travel_id) {
        this.atom_travel_id = atom_travel_id;
    }


    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }


    public long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public int getNumCar() {
        return numCar;
    }

    public void setNumCar(int numCar) {
        this.numCar = numCar;
    }
}