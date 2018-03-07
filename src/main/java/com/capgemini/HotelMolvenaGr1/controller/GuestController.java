package com.capgemini.HotelMolvenaGr1.controller;

import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.repository.IGuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guest/")
public class GuestController {
    @Autowired
    private IGuestRepository guestRepository;

    // find all table
    @RequestMapping(value="get", method= RequestMethod.GET)
    public Iterable<Guest> index(){
        return guestRepository.findAll();
    }

    // enter new guest into table
    @RequestMapping(value="saved", method = RequestMethod.POST)
    public void saveGuestList(@RequestBody Guest guestToSave){
        guestRepository.save(guestToSave);}

        // search for item in table
   @RequestMapping(value="search/{searchTerm}", method = RequestMethod.GET)
    public List<Guest> searchGuests(@PathVariable String searchTerm) {
            return guestRepository.findByLastNameContainingIgnoreCase(searchTerm);
    }

    // delete a person
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteGuest(@PathVariable long id)
    {
        guestRepository.delete(id);
    }

    // alter a person
    @RequestMapping(value = "change", method = RequestMethod.POST)
    public void changeGuest(@RequestBody String firstName, String lastName, String address, String postalCode, String town, String country, String telephoneNumber, String emailAddress){
//        guestRepository.changeGuest(firstName, lastName, address, postalCode, town, country, telephoneNumber, emailAddress);
    }
}
