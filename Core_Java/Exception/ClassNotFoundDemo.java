package com.jatin.Exception;

public class ClassNotFoundDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.fake.Driver");
    }
}