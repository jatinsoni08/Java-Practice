package com.jatin;

// Demonstration of different ways to call static members in Java
// All examples are kept simple and beginner-friendly

// Parent class to demonstrate inheritance case
class Parent1 {
    static void parentShow() {
        System.out.println("Static method from Parent class");
    }
}

// Interface to demonstrate static method in interface (Java 8+)
interface MyInterface {
    static void interfaceShow() {
        System.out.println("Static method inside Interface");
    }
}

// Main Demo class
public class StaticKeywordDemo extends Parent1 {

    // static variable (class level)
    static int num = 10;

    // static method
    static void show() {
        System.out.println("Value of num: " + num);
    }

    // static method to demonstrate local variable rule
    static void m1() {
        int a = 10;   // local variable (allowed)

        // static int b = 20;  // ❌ Not allowed
        // Reason: static variables cannot be declared inside methods
    }

    public static void main(String[] args) {

        // 1. Using Class Name (Recommended)
        System.out.println("1. Using Class Name (Recommended)");
        StaticKeywordDemo.show();
        System.out.println(StaticKeywordDemo.num);

        // 2. Direct Call Inside Same Class
        System.out.println("\n2. Direct Call Inside Same Class");
        show();
        System.out.println(num);

        // 3. Using Object Reference (Not Recommended)
        System.out.println("\n3. Using Object Reference (Not Recommended)");
        StaticKeywordDemo obj = new StaticKeywordDemo();
        obj.show();          // works, but should be avoided
        System.out.println(obj.num);

        // 4. Using Child Class Name (Inheritance)
        System.out.println("\n4. Using Child Class Name (Inheritance)");
        StaticKeywordDemo.parentShow();

        // 5. Static Method in Interface (Java 8+)
        System.out.println("\n5. Static Method in Interface (Java 8+)");
        MyInterface.interfaceShow();

        // 6. Static Method Containing Local Variable Rule
        System.out.println("\n6. Static Method & Local Variable Rule");
        m1();

        // 7. Static Import (Explained via Math class)
        System.out.println("\n7. Static Import Example");
        System.out.println(java.lang.Math.sqrt(25));
        System.out.println(java.lang.Math.max(10, 20));

        System.out.println("\nNOTE:");
        System.out.println("Static members belong to class, not object");
    }
}
