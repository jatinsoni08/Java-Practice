package com.jatin.Exception;
public class ExceptionDemo {
    public static void main(String[] args) {

        try {
            int a = 10;
            int b = 0;

            // Runtime Exception
            int result = a / b;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero\n");
        } finally {
            System.out.println("Execution completed");
        }
    }
}
