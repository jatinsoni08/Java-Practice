package com.jatin.Exception;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class FileNotFoundDemo {
    public static void main(String[] args) throws FileNotFoundException {
        new FileReader("missing.txt");
    }
}