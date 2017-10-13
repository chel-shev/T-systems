package com.tsystems.entity;

import javax.persistence.*;

/**
 * Created by user on 03.08.2017.
 */

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long role_id;
    @Column(name = "role")
    private String role;
    @Column(name = "removed")
    private boolean removed = false;

    public Role() {
    }

    public Role(String role, boolean removed) {
        this.role = role;
        this.removed = removed;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public boolean getRemoved() {
        return removed;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
