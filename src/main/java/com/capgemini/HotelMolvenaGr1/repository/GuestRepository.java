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

    public List<Guest> search(String searchTerm) {
        String searchTermLower;
        List<Guest> searchResults = new ArrayList<>();
        searchTermLower = searchTerm.toLowerCase();

        for (Guest guest : guestList) {
            String lastNameLower = guest.getLastName().toLowerCase();
            if (lastNameLower.contains(searchTermLower)) {
                searchResults.add(guest);
            }
        }
        return searchResults;
    }

    public void deleteGuest() {
        for (Guest guest : guestList) {
            guestList.remove(guest);
        }
    }

    public void changeGuest(String firstName, String lastName, String address, String postalCode, String town, String country, String telephoneNumber, String emailAddress) {
        for (Guest guest : guestList) {
            if (guest.getLastName() == lastName & guest.getFirstName() == firstName) {
                guest.setAddress(address);
                guest.setPostalCode(postalCode);
                guest.setTown(town);
                guest.setTelephoneNumber(telephoneNumber);
                guest.setEmailAddress(emailAddress);
            }
        }

    }


}
