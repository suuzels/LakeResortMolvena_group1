package com.capgemini.HotelMolvenaGr1.controller;

import com.capgemini.HotelMolvenaGr1.ERoomType;
import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.model.Room;
import com.capgemini.HotelMolvenaGr1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    private Guest guest;

    private Room room;


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

    // Find available rooms
    @RequestMapping(value = "api/rooms/available/{searchBool}", method = RequestMethod.GET)
    public List<Room> searchAvailableRooms(@PathVariable boolean searchBool){
        return roomRepository.findByIsOccupied(searchBool);
    }



}
