package com.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);
        deque.addLast(20);
        deque.addLast(30);

        System.out.println("Deque: " + deque);

        deque.pollFirst();
        deque.pollLast();

        System.out.println("Deque after removals: " + deque);
    }
}