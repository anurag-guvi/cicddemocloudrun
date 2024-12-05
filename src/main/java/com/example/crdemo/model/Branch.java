package com.example.crdemo.model;

public class Branch {

    private int branchId;
    private String branchName;
    private String location;
    private String managerName;

    public Branch() {
    }

    public Branch(int branchId, String branchName, String location, String managerName) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.location = location;
        this.managerName = managerName;
    }

    // Getters and setters for the fields
    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}