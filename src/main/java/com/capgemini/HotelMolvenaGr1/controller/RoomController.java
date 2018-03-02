package com.capgemini.HotelMolvenaGr1.controller;

import com.capgemini.HotelMolvenaGr1.ERoomType;
import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.model.Room;
import com.capgemini.HotelMolvenaGr1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    private Guest guest;

    private Room room;

    //private Staff staff;

    //private booking booking;

    @GetMapping("/voorbeeld")
    public String Voorbeeld() {
        return "<h1> Het voorbeeld werkt ook! <br><br> Verander deze pagina in de HotelController </h1>";
    }

    public void greet() {
        guest.greetGuest();
    }
//
//    @RequestMapping("/api/guest")
//    public List<guest> getGuests(){
//        GuestRegister newGuest = new GuestRegister();
//        newGuest.addGuest("Sasha", "Vollebregt", "Sportlaan 116", "1072GG",
//                "London", "Netheraldo", "0640718383", "volle@gmail.com");
//        newGuest.addGuest("Frank", "Vollebregt", "Sportlaan 116", "1072GG",
//                "Paris", "Netheraldo", "8282282883", "volle@gmail.com");
//        return newGuest.getGuestList();
//    }

    @Autowired
    private RoomRepository roomRepository;

    // Gets all rooms
    @RequestMapping(value = "api/rooms", method = RequestMethod.GET)
    public Iterable<Room> index() {
        return roomRepository.findAll();
    }

    // Posts a new room on add button click
    @RequestMapping(value = "api/rooms", method = RequestMethod.POST)
    public void save(@RequestBody Room roomToSave) {
        roomRepository.save(roomToSave);
    }

    // Deletes a database item when clicked
    @RequestMapping(value = "api/rooms/{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable long id) {
        roomRepository.delete(id);
    }


//    Changes a roomtype to the selected roomtype
//    @RequestMapping(value = "api/rooms/{id, roomType}", method = RequestMethod.POST)
//    public void editRoom(@PathVariable long id, ERoomType roomType) {
//        roomRepository.save(id, roomType);
//    }

    // public void checkIn();

    // public void checkOut();

    // public void pay();

}
