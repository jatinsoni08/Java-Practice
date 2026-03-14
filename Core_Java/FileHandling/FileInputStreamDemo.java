package com.fileHandling;

import java.io.FileInputStream;

public class FileInputStreamDemo {

    public static void main(String[] args) throws Exception {

        FileInputStream fis =
                new FileInputStream("new.txt");

        int i;

        while ((i = fis.read()) != -1) {

            System.out.print((char) i);

        }

        fis.close();
    }
}