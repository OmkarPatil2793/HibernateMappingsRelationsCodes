package com.mahagan.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long custId;

    private String custFirstName;

    private String custLastName;

    private String custMobileNo;

    private int custBirthYear;

    public Customer() {
    }

    public Customer(Long custId, String custFirstName, String custLastName, String custMobileNo, int custBirthYear) {
        this.custId = custId;
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
        this.custMobileNo = custMobileNo;
        this.custBirthYear = custBirthYear;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustMobileNo() {
        return custMobileNo;
    }

    public void setCustMobileNo(String custMobileNo) {
        this.custMobileNo = custMobileNo;
    }

    public int getcustBirthYear() {
        return custBirthYear;
    }

    public void setCustBirthYear(int custBirthDate) {
        this.custBirthYear = custBirthDate;
    }
}
