package com.capgemini;

public class Staff {
    private String typeofStaff;
    private String staffName;
    private String password;
    private String username;

    public Staff(String typeofStaff, String staffName, String password, String username) {
        this.typeofStaff = typeofStaff;
        this.staffName = staffName;
        this.password = password;
        this.username = username;
    }

    public String getTypeofStaff() {
        return typeofStaff;
    }

    public void setTypeofStaff(String typeofStaff) {
        this.typeofStaff = typeofStaff;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
