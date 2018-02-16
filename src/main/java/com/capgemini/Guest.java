package com.capgemini;

public class Guest {

    private String firstName;

    private String lastName;

    private int passportNumber;

    private int phoneNumber;

    private String emailAddress;

    private boolean isCheckedIn;

    public Guest (String firstName, String lastName, int passportNumber, int phoneNumber, String emailAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public void greetGuest() {
        System.out.println("Welcome " + this.firstName + " " + this.lastName);
    }




}
