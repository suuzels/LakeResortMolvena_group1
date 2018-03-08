package com.capgemini.HotelMolvenaGr1.data;

import com.capgemini.HotelMolvenaGr1.model.Booking;

public class BookingModel {

    private Booking booking;

    private long guestId;

    private long roomId;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}

