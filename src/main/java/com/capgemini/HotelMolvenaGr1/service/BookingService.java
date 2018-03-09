package com.capgemini.HotelMolvenaGr1.service;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.model.Room;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import com.capgemini.HotelMolvenaGr1.repository.IGuestRepository;
import com.capgemini.HotelMolvenaGr1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteBooking(Long id){
        Booking victum = this.bookingRepository.findOne(id);
        for (Room r : victum.getRooms()){
            r.getBookingOwner().remove(victum);
            victum.getRooms().remove(r);
        }
        this.bookingRepository.delete(id);
    }

}
