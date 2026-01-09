package com.jatin.Exception;

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) throws InvalidAgeException {
        int age = 15;
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18+");
        }
    }
}