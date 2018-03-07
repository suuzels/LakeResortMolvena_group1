package com.capgemini.HotelMolvenaGr1.controller;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import com.capgemini.HotelMolvenaGr1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // RequestMappings

    // Get all bookings
    @RequestMapping(value = "api/bookings/get", method = RequestMethod.GET)
    public Iterable<Booking> index() {
        return bookingRepository.findAll();
    }

    // Add booking
    @RequestMapping(value = "api/bookings/save", method = RequestMethod.POST)
    public void save(@RequestBody Booking bookingToSave) {
        bookingRepository.save(bookingToSave);
    }

    // Delete booking
    @RequestMapping(value = "api/bookings/{id}", method = RequestMethod.DELETE)
    public void deleteBooking(@PathVariable long id) {
        bookingRepository.delete(id);
    }

    // Edit booking
    @RequestMapping(value = "api/bookings/{id}", method = RequestMethod.PUT)
    public void editBooking(@PathVariable long id, @RequestBody Booking bookingToEdit) {
        bookingRepository.save(bookingToEdit);
    }

    // Find booking
    @RequestMapping(value = "api/bookings/search/{searchTerm}", method = RequestMethod.GET)
    public Iterable<Booking> searchBooking(@PathVariable String searchTerm) {
        return bookingRepository.findByGuestContainingIgnoreCase(searchTerm);
    }


}
