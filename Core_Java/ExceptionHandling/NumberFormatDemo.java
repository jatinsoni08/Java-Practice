package com.jatin.Exception;
public class NumberFormatDemo {
    public static void main(String[] args) {
        int num = Integer.parseInt("abc"); // Exception
        System.out.println(num);
    }
}