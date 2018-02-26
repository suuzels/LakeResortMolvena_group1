package com.capgemini.HotelMolvenaGr1.model;
import com.capgemini.HotelMolvenaGr1.ERoomType;

public class Room {

    // Variabelen
    private ERoomType roomType;
    private boolean isAvailable;
    private String roomID;
    private double defaultPrice;
    private String roomName;


    // Constructor

    public Room(){}

    public Room(ERoomType roomType, boolean isAvailable, String roomID, double defaultPrice, String roomName) {
        this.roomType = roomType;
        this.isAvailable = isAvailable;
        this.roomID = roomID;
        this.defaultPrice = defaultPrice;
        this.roomName = roomName;
    }

    // Getters setters


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

    // Methodess
    public void alterRoom(){

    }

    public void addRoom(){
    }

    public double calculateEventPrice() {
        double eventPrice = defaultPrice * 2;
        System.out.println("The new price of the room is: " + eventPrice + " euro.");
        return eventPrice;
    }

}