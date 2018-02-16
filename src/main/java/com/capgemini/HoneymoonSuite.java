package com.capgemini;

public class HoneymoonSuite extends Room {

    // Properties
    private double defaultPrice = 345; // defaultprice = 345

    // Constructor
    public HoneymoonSuite() {
    }

    public void calculateEventPrice() {
        double eventPrice = defaultPrice * 2;
        System.out.println("The new price of the room is: " + eventPrice + " euro.");
    }
}
