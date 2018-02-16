package com.capgemini;

public abstract class Room {

    public Room(){}

    private boolean isOccupied;

    private int roomID;

    private double defaultPrice;

    private int numberOfBeds;

    public abstract void calculateEventPrice();


}
