package com.capgemini.HotelMolvenaGr1.repository;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

//    private Booking booking;
    // List of bookings

//    ArrayList<Booking> bookings = new ArrayList<>();

//    public BookingRepository() {
//        this.bookings = new ArrayList<>();
//
//        Booking booking1 = new Booking();
//        booking1.setCheckInDate("1 maart");
//        booking1.setCheckOutDate("2 maart");
//        booking1.setGuest("Pietje");
//        booking1.setRoom("2");
//        booking1.setWantsBreakfast(true);
//        booking1.setWantsBabybed(true);
//
//        this.bookings.add(booking1);
//    }

    // Methods

//    public Booking save(Booking booking) {
//        bookings.add(booking);
//        return booking;
//    }
//
//    public void deleteBooking() {
//        for (Booking booking : bookings) {
//            bookings.remove(booking);
//        }
//    }
//
//
//    // Getters and setters
//
//    public Booking getBooking() {
//        return booking;
//    }
//
//    public void setBooking(Booking booking) {
//        this.booking = booking;
//    }
//
//    public ArrayList<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(ArrayList<Booking> bookings) {
//        this.bookings = bookings;
//    }

}
