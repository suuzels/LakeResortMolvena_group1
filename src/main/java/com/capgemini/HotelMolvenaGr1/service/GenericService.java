package com.capgemini.HotelMolvenaGr1.service;

import com.capgemini.HotelMolvenaGr1.EBedsType;
import com.capgemini.HotelMolvenaGr1.ERoomType;
import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.model.Room;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import com.capgemini.HotelMolvenaGr1.repository.IGuestRepository;
import com.capgemini.HotelMolvenaGr1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class GenericService {
    @Autowired
    private IGuestRepository iGuestrepository;

    @Autowired
    private BookingRepository iBookingrepository;

    @Autowired
    private RoomRepository iRoomrepository;


    @PostConstruct
    public void init(){
//        Booking b1 = new Booking();
//        b1.setCheckInDate("22-03-2018");
//        b1.setCheckOutDate("23-03-2018");
//        b1.setRoom("5");
//        b1.setWantsBabybed(false);
//        b1.setWantsBreakfast(true);
//
//        // link the guest
////        b1.setGuest();
//
//        Booking b2 = new Booking();
//        b2.setCheckInDate("22-04-2018");
//        b2.setCheckOutDate("23-05-2018");
//        b2.setRoom("5");
//        b2.setWantsBabybed(false);
//        b2.setWantsBreakfast(true);
//
//        this.iBookingrepository.save(b1);
//        this.iBookingrepository.save(b2);
//
//        Guest g1 = new Guest();
//        g1.setFirstName("Henk");
//        g1.setLastName("Vol");
//        g1.setAddress("help");
//        g1.setEmailAddress("@");
//        g1.setPostalCode("v");
//        g1.setTelephoneNumber("dd");
//        g1.setTown("web");
//        g1.setCountry("life");
//
//        this.iGuestrepository.save(g1);
//
//        Room r1 = new Room();
//        r1.setDefaultPrice(12);
//        r1.setOccupied(true);
//        r1.setRoomName("sasha");
//        r1.setRoomType(ERoomType.LUXURY);
//        r1.setRoomNumber(122);
//        r1.seteBedsType(EBedsType.DOUBLE);
//        r1.setNumberOfPeople(2);
//
//        this.iRoomrepository.save(r1);
//
//        b1.setGuest(g1);
//        b2.setGuest(g1);
//
//        b1.addRoom(r1);
//
//        this.iBookingrepository.save(b1);
//        this.iBookingrepository.save(b2);
//        this.iGuestrepository.save(g1);
    }

}
