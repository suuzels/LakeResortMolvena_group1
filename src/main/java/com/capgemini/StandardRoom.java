package com.capgemini;

public class StandardRoom extends Room {

    // Properties
    private double defaultPrice = 89; // defaultprice = 89

    // Constructor
    public StandardRoom(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public StandardRoom(){}

    public void calculateEventPrice() {
        double eventPrice = defaultPrice * 3;
        System.out.println("The new price of the room is: " + eventPrice + " euro.");
    }

}

