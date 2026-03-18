package com.jatin.setInterface;

import java.util.LinkedHashSet;
public class LinkedHashSetExample {

    public static void main(String[] args) {

        // Creating a LinkedHashSet
        LinkedHashSet<String> fruits = new LinkedHashSet<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        // Duplicate element (will not be added)
        fruits.add("Apple");

        // Display elements (in insertion order)
        System.out.println("LinkedHashSet Elements:");
        System.out.println(fruits);

        // Remove first element
        fruits.removeFirst();
        System.out.println("After removing first element: " + fruits);

        // Remove last element
        fruits.removeLast();
        System.out.println("After removing last element: " + fruits);

        // Iterating through the set
        System.out.println("Iterating elements:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Checking if element exists
        System.out.println("Contains Mango? " + fruits.contains("Mango"));

        // Size of set
        System.out.println("Size: " + fruits.size());

        // Clearing set
        fruits.clear();
        System.out.println("After clearing set: " + fruits);
    }
}