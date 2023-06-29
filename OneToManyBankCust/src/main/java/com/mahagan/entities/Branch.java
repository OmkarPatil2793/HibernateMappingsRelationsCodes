package com.mahagan.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long branchId;

    private String branchName;

    private String branchLocation;

    private String branchIFSC;

    public Branch() {
    }

    public Branch(Long branchId, String branchName, String branchLocation, String branchIFSC) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchLocation = branchLocation;
        this.branchIFSC = branchIFSC;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getBranchIFSC() {
        return branchIFSC;
    }

    public void setBranchIFSC(String branchIFSC) {
        this.branchIFSC = branchIFSC;
    }
}
