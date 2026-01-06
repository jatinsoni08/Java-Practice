package com.jatin.oops.relationship_composition;

// Composition example
public class House {

    private Room room;

    public House() {
        room = new Room(); // created inside House
        System.out.println("House created");
    }
}
