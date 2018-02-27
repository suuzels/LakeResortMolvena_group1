package com.capgemini.HotelMolvenaGr1.model;
import com.capgemini.HotelMolvenaGr1.EBedsType;
import com.capgemini.HotelMolvenaGr1.ERoomType;

public class Room {

    // Variables
    private ERoomType roomType;
    private boolean isAvailable;
    private String roomID;
    private double defaultPrice;
    private String roomName;
    private int numberOfPeople;
    private EBedsType eBedsType;

    // Constructors

    public Room(){}

    public Room(ERoomType roomType, boolean isAvailable, String roomID, double defaultPrice, String roomName, int numberOfPeople, EBedsType eBedsType) {
        this.roomType = roomType;
        this.isAvailable = isAvailable;
        this.roomID = roomID;
        this.defaultPrice = defaultPrice;
        this.roomName = roomName;
        this.numberOfPeople = numberOfPeople;
        this.eBedsType = eBedsType;
    }

    // Getters and setters


    public ERoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(ERoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }


    public double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public EBedsType geteBedsType() {
        return eBedsType;
    }

    public void seteBedsType(EBedsType eBedsType) {
        this.eBedsType = eBedsType;
    }

    // Methodess

//    public double calculateEventPrice() {
//        double eventPrice = defaultPrice * 2;
//        System.out.println("The new price of the room is: " + eventPrice + " euro.");
//        return eventPrice;
//    }

}