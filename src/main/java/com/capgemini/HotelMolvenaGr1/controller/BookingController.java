package com.capgemini.HotelMolvenaGr1.controller;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // RequestMappings

    @RequestMapping(value = "api/bookings/get", method = RequestMethod.GET)
    public Iterable<Booking> index() {
        return bookingRepository.getBookings();
    }

    @RequestMapping(value = "api/bookings/save", method = RequestMethod.POST)
    public void save(Booking bookingToSave) {
        bookingRepository.save(bookingToSave);
    }

    @RequestMapping(value = "api/bookings/delete", method = RequestMethod.DELETE)
    public void deleteBooking() {
        bookingRepository.deleteBooking();
    }

}
