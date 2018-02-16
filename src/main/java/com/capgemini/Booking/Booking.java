package com.capgemini.Booking;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *    System.out.println( "Ciao Lago di Molvena!" );
 DateFormat theFormatOfDate = new SimpleDateFormat("d-M-yyyy");

 ArrayList<BookedDates> listOfDatesBooked = new ArrayList<BookedDates>();
 BookedDates guest1 = new BookedDates(theFormatOfDate.parse("12-10-2018"),theFormatOfDate.parse("12-10-2018"));
 listOfDatesBooked.add(guest1);
 System.out.println(guest1.toString());

 Date checkInDate = theFormatOfDate.parse("12-10-2018");
 Date checkOutDate = theFormatOfDate.parse("12-12-2018");
 Booking enterDate = new Booking(checkInDate, checkOutDate);

 enterDate.checkAvailability();
 */
public class Booking {
    private Date checkInDate;
    private Date checkOutDate;

    private boolean isRoomAvailable=true;
    private int quantityOfRooms=1;

    // extra properties
    private boolean isPaid;
    private boolean wantsBabybed;


    /**
     * You want to check if check in date if rooms are available and after say check out
     */
    public Booking(Date checkInDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = null;
    }


    /**
     * Enter the check in date or check out date
     * @param checkInDate
     * @param checkOutDate
     */
    public Booking(Date checkInDate, Date checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        System.out.printf("%s %tB %<te, %<tY", "Check in:", checkInDate);
        System.out.printf("\n%s %tB %<te, %<tY", "Check out: ", checkOutDate);
    }

    /**
     * Check the availibilitie
     * 1. is room false - no rooms are available
     * 2. otherwise -
     *
     *
     * @return
     */

    public void checkAvailability(){
        // go into database to check dates

        if(!this.isRoomAvailable){
            System.out.println("Sorry, there are no rooms available");
            return;
        }

        this.quantityOfRooms--;
        System.out.println("\n quantity " + this.quantityOfRooms);

        if(this.quantityOfRooms == 0){
            this.isRoomAvailable = false;
            System.out.println(this.isRoomAvailable);
            return;
        }

    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isWantsBabybed() {
        return wantsBabybed;
    }

    public void setWantsBabybed(boolean wantsBabybed) {
        this.wantsBabybed = wantsBabybed;
    }

    public int getQuantityOfRooms() {
        return quantityOfRooms;
    }

    public void setQuantityOfRooms(int quantityOfRooms) {
        this.quantityOfRooms = quantityOfRooms;
    }

    public boolean isRoomAvailable() {
        return isRoomAvailable;
    }

    public void setRoomAvailable(boolean roomAvailable) {
        isRoomAvailable = roomAvailable;
    }
}
