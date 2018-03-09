package com.capgemini.HotelMolvenaGr1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Guest implements Serializable {
    // automatic id guest
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // one guest can be linked with more bookings
    @JsonIgnore
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "guest")
    private List<Booking> booking;

    // start data of the guests
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String town;
    private String country;
    private String telephoneNumber;
    private String emailAddress;

    public Guest(){}


    //Getter and setter
    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public long getId() {
        return id;
    }

    public void greetGuest(){
        System.out.println("Welcome " + this.firstName + " " + this.lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
