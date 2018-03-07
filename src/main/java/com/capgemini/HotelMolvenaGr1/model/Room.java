package com.capgemini.HotelMolvenaGr1.model;

import com.capgemini.HotelMolvenaGr1.EBedsType;
import com.capgemini.HotelMolvenaGr1.ERoomType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // This private long id is needed for the Interface RoomRepository
    private long id;


    // Variables
    private int roomNumber;
    private ERoomType roomType;
    private boolean isOccupied;
    private double defaultPrice;
    private String roomName;
    private int numberOfPeople;
    private EBedsType eBedsType;

    // Constructor
    public Room() {

    }

    // Getters and setters

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public ERoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(ERoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
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

    public long getId() {
        return id;
    }


}