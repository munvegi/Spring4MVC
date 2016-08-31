package com.munvegi.springmvc.model;

import javax.persistence.*;

/**
 * Created by admin on 04/08/2016.
 */
@Entity
@Table(name = "PHONE")
public class Phone {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Phone() {
    }

    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public Phone(int id, String number, String type, User user) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.user = user;
    }

    public Phone(String number, String type, User user) {
        this.number = number;
        this.type = type;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
