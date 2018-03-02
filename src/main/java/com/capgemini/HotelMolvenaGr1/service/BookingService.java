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

        this.bookingRepository.save(b1);
    }
}
