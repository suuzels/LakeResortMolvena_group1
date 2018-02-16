package com.capgemini;

public class LuxuryRoom extends Room {

    // Properties
    private double defaultPrice; // defaultprice = 149

    // Constructor
    public LuxuryRoom(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public void calculateEventPrice(){
        double eventPrice = defaultPrice * 2;
        System.out.println("The new price of the room is: " + eventPrice);

}}
