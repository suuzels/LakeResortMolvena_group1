package com.capgemini;

public class HoneymoonSuite extends Room {

    // Properties
    private double defaultPrice; // defaultprice = 345

    // Constructor
    public HoneymoonSuite(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public void calculateEventPrice() {
        double eventPrice = defaultPrice * 2;
        System.out.println("The new price of the room is: " + eventPrice);
    }
}
