package com.mahagan.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long countryID;

    private  String countryName, countryCapital;

    private int countryCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stateID")
    private State state;

    public Country() {
    }

    public Country(Long countryID, String countryName, String countryCapital, int countryCode, State state) {
        this.countryID = countryID;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.countryCode = countryCode;
        this.state = state;
    }

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
