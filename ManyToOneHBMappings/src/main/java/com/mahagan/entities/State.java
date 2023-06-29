package com.mahagan.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long stateID;

    private String stateName, stateCapital, stateInitial;
    private int stateCode, stateOriginYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countryId")
    private Country country;

    public State() {
    }

    public State(Long stateID, String stateName, String stateCapital, String stateInitial, int stateCode, int stateOriginYear, Country country) {
        this.stateID = stateID;
        this.stateName = stateName;
        this.stateCapital = stateCapital;
        this.stateInitial = stateInitial;
        this.stateCode = stateCode;
        this.stateOriginYear = stateOriginYear;
        this.country = country;
    }

    public Long getStateID() {
        return stateID;
    }

    public void setStateID(Long stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCapital() {
        return stateCapital;
    }

    public void setStateCapital(String stateCapital) {
        this.stateCapital = stateCapital;
    }

    public String getStateInitial() {
        return stateInitial;
    }

    public void setStateInitial(String stateInitial) {
        this.stateInitial = stateInitial;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public int getStateOriginYear() {
        return stateOriginYear;
    }

    public void setStateOriginYear(int stateOriginYear) {
        this.stateOriginYear = stateOriginYear;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
