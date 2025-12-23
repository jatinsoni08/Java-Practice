package com.jatin;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {

        // Creating HashSet
        HashSet<Integer> hs = new HashSet<>();

        // Adding elements
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add(40);
        hs.add(10);   // Duplicate (will be ignored)
        hs.add(null); // One null allowed
        hs.add(null); // Ignored (duplicate null)

        // Printing HashSet
        System.out.println("HashSet Elements: " + hs);

        // Checking element
        System.out.println("Contains 20? " + hs.contains(20));

        // Removing element
        hs.remove(30);
        System.out.println("After removing 30: " + hs);

        // Size
        System.out.println("Size of HashSet: " + hs.size());

        // Iterating HashSet
        System.out.println("Iterating HashSet:");
        for (Integer i : hs) {
            System.out.println(i);
        }
    }
}
