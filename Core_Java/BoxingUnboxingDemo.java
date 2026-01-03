package com.jatin;

import java.util.ArrayList;
import java.util.List;

public class BoxingUnboxingDemo {

    public static void main(String[] args) {

        // Auto boxing: primitive → wrapper
        int a = 10;
        Integer obj = a;   // auto boxing
        System.out.println("Autoboxed Integer: " + obj);

        // Un-boxing: wrapper → primitive
        Integer value = 20;
        int b = value;    // un-boxing
        System.out.println("\nUnboxed int: " + b);

        // Auto boxing in collections
        List<Integer> list = new ArrayList<>();
        list.add(5);      // int → Integer (auto boxing)
        list.add(10);
        list.add(15);

        // Un-boxing during iteration and arithmetic
        int sum = 0;
        for (Integer i : list) {
            sum += i;     // Integer → int (un-boxing)
        }
        System.out.println("\nSum: " + sum);

        // Internal working example
        Integer x = 30;
        int y = x.intValue(); // explicit un boxing
        System.out.println("\nExplicit unboxing: " + y);

        // Common pitfall
        Integer n = null;
        // int z = n; // ❌ NullPointerException
    }
}
