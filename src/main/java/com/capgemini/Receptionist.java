package com.capgemini;

public class Receptionist {

    public Receptionist(Guest guest){
        this.guest = guest;
        greet();
    }

    private Guest guest;



    //private Room room

    //private Staff staff

    //private Booking booking


    // -----------------------

    public void greet(){
        guest.greetGuest();
    }

    // public void checkIn();

    // public void checkOut();

    // public void pay();

    //


}
