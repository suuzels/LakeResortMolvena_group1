package com.capgemini.HotelMolvenaGr1.service;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import com.capgemini.HotelMolvenaGr1.repository.GuestRepository;
import com.capgemini.HotelMolvenaGr1.repository.IGuestRepository;
import com.capgemini.HotelMolvenaGr1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private IGuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;



    public void update(long id, Booking bookingToEdit) {

    }
}
