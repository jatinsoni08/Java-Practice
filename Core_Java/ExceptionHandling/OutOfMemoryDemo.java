package com.jatin.Exception;

import java.util.ArrayList;

public class OutOfMemoryDemo {
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        while (true) {
            list.add(new int[1000000]);
        }
    }
}