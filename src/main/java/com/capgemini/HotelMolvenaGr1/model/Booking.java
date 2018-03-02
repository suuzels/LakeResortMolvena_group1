package com.capgemini.HotelMolvenaGr1.model;

import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.model.Room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Booking {

    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String guest;
    private String room;
    private String checkInDate;
    private String checkOutDate;
    private int numberOfNights;
    private int numberOfGuests;
    private boolean isPaid;
    private boolean wantsBabybed;
    private boolean wantsBreakfast;

    // Constructor
    public Booking() {
    }

    // Getters and setters
    
    public long getId() {
        return id;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isWantsBabybed() {
        return wantsBabybed;
    }

    public void setWantsBabybed(boolean wantsBabybed) {
        this.wantsBabybed = wantsBabybed;
    }

    public boolean isWantsBreakfast() {
        return wantsBreakfast;
    }

    public void setWantsBreakfast(boolean wantsBreakfast) {
        this.wantsBreakfast = wantsBreakfast;
    }
}

