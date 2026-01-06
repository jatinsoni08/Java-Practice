package com.jatin.oops.inheritence;

// Superclass
public class Bicycle {

    // Parent class variables
    protected int speed;
    protected int gear;

    // Parent class constructor
    public Bicycle(int speed, int gear) {
        this.speed = speed;
        this.gear = gear;
        System.out.println("Bicycle constructor called");
    }

    // Parent class method
    public void display() {
        System.out.println("Speed: " + speed);
        System.out.println("Gear: " + gear);
    }
}
