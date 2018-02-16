package com.capgemini;

public class LuxuryRoom extends Room {

    // Properties
    private double defaultPrice = 149; // defaultprice = 149

    // Constructor
    public LuxuryRoom() {
    }

    public void calculateEventPrice(){
        double eventPrice = defaultPrice * 4;
        System.out.println("The new price of the room is: " + eventPrice + " euro.");

}}
