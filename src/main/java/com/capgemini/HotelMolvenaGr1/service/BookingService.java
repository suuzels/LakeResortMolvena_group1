package com.capgemini.HotelMolvenaGr1.service;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.model.Room;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import com.capgemini.HotelMolvenaGr1.repository.IGuestRepository;
import com.capgemini.HotelMolvenaGr1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Transactional
    public void deleteBooking(final long id){

        if(this.bookingRepository.exists(id)) {

            Booking victim = this.bookingRepository.findOne(id);
            for (Room r : victim.getRooms()){
                r.getBookingOwner().remove(victim);
                victim.getRooms().remove(r);
            }
            this.bookingRepository.delete(id);
        }
    }
}