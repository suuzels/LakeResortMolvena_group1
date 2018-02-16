package com.capgemini;

public class StandardRoom extends Room {

    // Properties
    private double defaultPrice; // defaultprice = 89

    // Constructor
    public StandardRoom(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public void calculateEventPrice() {
        double eventPrice = defaultPrice * 2;
        System.out.println("The new price of the room is: " + eventPrice);
    }
}

