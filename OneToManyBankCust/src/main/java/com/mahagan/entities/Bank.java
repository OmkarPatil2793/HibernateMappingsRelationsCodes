package com.mahagan.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bank")
public class Bank implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long bankId;

    private String bankName;

    private String bankType;

    private String bankHeadOffice;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankId")
    //@OrderColumn(name = "type")
    private List<Customer> customers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankId")
    private List<Branch> branches;

    public Bank() {
    }

    public Bank(Long bankId, String bankName, String bankType, String bankHeadOffice, List<Customer> customers, List<Branch> branches) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.bankType = bankType;
        this.bankHeadOffice = bankHeadOffice;
        this.customers = customers;
        this.branches = branches;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBankHeadOffice() {
        return bankHeadOffice;
    }

    public void setBankHeadOffice(String bankHeadOffice) {
        this.bankHeadOffice = bankHeadOffice;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
