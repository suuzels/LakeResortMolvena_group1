package com.capgemini.HotelMolvenaGr1.model;
import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.model.Room;

import java.util.Date;


public class Booking {

    // Variables
    private int bookingId;
    private Guest guest;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private int numberOfNights;
    private int numberOfGuests;
    private boolean isPaid;
    private boolean wantsBbabybed;
    private boolean wantsBreakfast;

    // Constructor
    public Booking() {
    }

    public Booking(int bookingId, Guest guest, Room room, Date checkInDate, Date checkOutDate, int numberOfNights, int numberOfGuests, boolean isPaid, boolean wantsBbabybed, boolean wantsBreakfast) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfNights = numberOfNights;
        this.numberOfGuests = numberOfGuests;
        this.isPaid = isPaid;
        this.wantsBbabybed = wantsBbabybed;
        this.wantsBreakfast = wantsBreakfast;
    }

// Getters and setters


    public int getBookingId() {
        return bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
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

    public boolean isWantsBbabybed() {
        return wantsBbabybed;
    }

    public void setWantsBbabybed(boolean wantsBbabybed) {
        this.wantsBbabybed = wantsBbabybed;
    }

    public boolean isWantsBreakfast() {
        return wantsBreakfast;
    }

    public void setWantsBreakfast(boolean wantsBreakfast) {
        this.wantsBreakfast = wantsBreakfast;
    }
}

