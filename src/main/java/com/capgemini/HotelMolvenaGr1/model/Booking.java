package com.capgemini.HotelMolvenaGr1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Booking {

    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // more than 1 booking can be linked to 1 guest
    @ManyToOne
    private Guest guest;

    // multiple bookings can be linked with multiple rooms
    @ManyToMany
    private Set<Room> rooms = new HashSet<>();

    // linked to manytomany
    public void addRoom(Room r){
        if(this.rooms == null){
            this.rooms=new HashSet<>();
        }
        this.rooms.add(r);
        r.getBookingOwner().add(this);
    }

    private String room;
    private String checkInDate;
    private String checkOutDate;
    private int numberOfNights;
    private int numberOfGuests;
    private boolean isPaid;
    private boolean wantsBabybed;
    private boolean wantsBreakfast;
    private boolean isCheckedIn;

    // Constructor
    public Booking() {
    }

    // Getters and setters

    public Set<Room> getRooms() {
        return rooms;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public long getId() {
        return id;
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

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }
}

