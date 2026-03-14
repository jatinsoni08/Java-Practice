package com.fileHandling;

import java.io.FileOutputStream;

public class FileOutputStreamDemo {

    public static void main(String[] args) throws Exception {

        String name = "Jatin Soni";

        byte[] byteArray = name.getBytes();

        FileOutputStream fos =
                new FileOutputStream("new.txt");

        fos.write(byteArray);

        System.out.println("File written successfully");

        fos.close();
    }
}