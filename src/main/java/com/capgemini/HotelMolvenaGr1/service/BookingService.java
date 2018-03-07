package com.capgemini.HotelMolvenaGr1.service;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    @PostConstruct
    public void init() {
        Booking b1 = new Booking();
        b1.setCheckInDate("2018-03-05");
        b1.setCheckOutDate("2018-03-07");
        b1.setGuest("Versnel");
        b1.setRoom("123");
        b1.setWantsBreakfast(true);
        b1.setWantsBabybed(false);

        this.bookingRepository.save(b1);
    }

    public void update(long id, Booking bookingToEdit) {

    }
}
