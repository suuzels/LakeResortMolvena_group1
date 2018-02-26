package com.capgemini.HotelMolvenaGr1.repository;

import com.capgemini.HotelMolvenaGr1.model.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestRepository {
    private List<Guest> guestList = new ArrayList<Guest>();

    public GuestRepository(){
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public Guest saveGuestList(Guest guest) {
       guestList.add(guest);
       return guest;
    }


    // i want to remember the guest
    public Guest rememberGuest(Guest guest){
        guestList.add(guest);
        return guest;
    }

    public String searchGuest(){
        GuestRegister guest = new GuestRegister();
        boolean result = guest.searchGuest("Sasha");
        if(result) {
            return "found";
        }else{
            return "not found";
        }
    }

}
