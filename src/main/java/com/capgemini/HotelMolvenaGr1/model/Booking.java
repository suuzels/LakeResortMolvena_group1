package com.capgemini.HotelMolvenaGr1.model;
import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.model.Room;

import java.util.Date;


public class Booking {

    private Guest guest;

    private Room room;

    private Date checkInDate;

    private Date checkOutDate;

    private int numberOfGuests;

    private boolean isPaid;

    private boolean babybed;

    private int bookingID;


    public Booking(){

    }

    /**
     * You want to check if check in date if rooms are available and after say check out
     */
    public Booking(Date checkInDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = null;
    }


    /**
     * Enter the check in date or check out date
     * @param checkInDate
     * @param checkOutDate
     */
    public Booking(Date checkInDate, Date checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        System.out.printf("%s %tB %<te, %<tY", "Check in:", checkInDate);
        System.out.printf("\n%s %tB %<te, %<tY", "Check out: ", checkOutDate);
    }

    /**
     * Check the availibilitie
     * 1. is room false - no rooms are available
     * 2. otherwise -
     *
     *
     * @return
     */


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

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public boolean isBabybed() {
        return babybed;
    }

    public void setBabybed(boolean babybed) {
        this.babybed = babybed;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
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
}
