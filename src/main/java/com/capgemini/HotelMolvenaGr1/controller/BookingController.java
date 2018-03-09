package com.capgemini.HotelMolvenaGr1.controller;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import com.capgemini.HotelMolvenaGr1.repository.IGuestRepository;
import com.capgemini.HotelMolvenaGr1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private IGuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

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
        Booking update = this.bookingRepository.findOne(id);

        Guest g = this.guestRepository.findOne(bookingToEdit.getGuest().getId());

        update.setGuest(g);

        // deze moet uitgecomment blijven anders werkt het niet
//        update.addRoom(bookingToEdit.getRooms().iterator().next());
        update.setCheckInDate(bookingToEdit.getCheckInDate());
        update.setCheckOutDate(bookingToEdit.getCheckOutDate());
        update.setWantsBabybed(bookingToEdit.isWantsBabybed());
        update.setWantsBreakfast(bookingToEdit.isWantsBreakfast());

        this.guestRepository.save(g);

        // deze moet uitgecomment blijven anders werkt het niet
//        this.roomRepository.save(bookingToEdit.getRooms().iterator().next());

        this.bookingRepository.save(bookingToEdit);
    }

    // Find booking
    @RequestMapping(value = "api/bookings/search/{searchTerm}", method = RequestMethod.GET)
    public Iterable<Booking> searchBooking(@PathVariable String searchTerm) {
        return bookingRepository.findByCheckInDateContaining(searchTerm);
    }


}
