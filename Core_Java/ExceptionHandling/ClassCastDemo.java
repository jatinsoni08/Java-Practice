package com.jatin.Exception;
public class ClassCastDemo {
    public static void main(String[] args) {
        Object obj = "Java";
        Integer i = (Integer) obj; // Exception
        System.out.println(i);
    }
}