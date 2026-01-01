package com.jatin;

public class ArrayDemo {
    public static void main(String[] args) {

        // 1. Array declaration and initialization
        int[] arr = {10, 20, 30, 40, 50};

        // Accessing elements
        System.out.println("First element: " + arr[0]);
        System.out.println("Last element: " + arr[arr.length - 1]);

        System.out.println("--------------------");

        // 2. Iterating using for loop
        System.out.println("Using for loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("--------------------");

        // 3. Iterating using for-each loop
        System.out.println("Using for-each loop:");
        for (int value : arr) {
            System.out.println(value);
        }

        System.out.println("--------------------");

        // 4. Array size
        System.out.println("Array length: " + arr.length);
    }
}
