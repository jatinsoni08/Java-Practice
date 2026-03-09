package com.queue;

import java.util.ArrayDeque;

public class ArrayDequeExample {

    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.add(10);
        deque.add(20);
        deque.add(30);

        System.out.println("ArrayDeque: " + deque);

        deque.addFirst(5);
        deque.addLast(40);

        System.out.println("Updated ArrayDeque: " + deque);
    }
}