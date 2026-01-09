package com.jatin.Exception;

public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Exception caught");
        } finally {
            System.out.println("Finally always executes");
        }
    }
}
