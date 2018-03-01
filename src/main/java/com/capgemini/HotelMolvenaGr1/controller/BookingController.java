package com.capgemini.HotelMolvenaGr1.controller;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // RequestMappings

    @RequestMapping(value = "api/bookings/get", method = RequestMethod.GET)
    public Iterable<Booking> index() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "api/bookings/save", method = RequestMethod.POST)
    public void save(@RequestBody Booking bookingToSave) {
        bookingRepository.save(bookingToSave);
    }

    @RequestMapping(value = "api/bookings/{id}", method = RequestMethod.DELETE)
    public void deleteBooking(@PathVariable long id) {
        bookingRepository.delete(id);
    }

}
