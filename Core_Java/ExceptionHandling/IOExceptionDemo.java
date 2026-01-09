package com.jatin.Exception;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("test.txt"); // Checked Exception
    }
}
