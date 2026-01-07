package com.jatin.oops.polymorphism;
class A {
    static void show() {
        System.out.println("Class A");
    }
}

class B extends A {
    static void show() {
        System.out.println("Class B");
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        A obj = new B();
        obj.show(); // Output: Class A
    }
}
