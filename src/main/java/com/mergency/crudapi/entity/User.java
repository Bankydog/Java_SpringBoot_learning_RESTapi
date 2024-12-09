package com.mergency.crudapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("firstname")
    private String fName;
    @JsonProperty("lastname")
    private String lName;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    //////////////////// Getter ////////////////////
    public String getFirstName() {
        return fName;
    }

    public String getLastName() {
        return lName;
    }

    public int getID() {
        return id;
    }

    //////////////////// Setter ////////////////////
    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }

    public void setID(int id) {
        this.id = id;
    }
}
