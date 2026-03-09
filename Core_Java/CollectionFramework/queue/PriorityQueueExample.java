package com.queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(100);
        pq.add(50);
        pq.add(150);
        pq.add(25);

        System.out.println("PriorityQueue: " + pq);

        System.out.println("Head element: " + pq.peek());

        pq.poll();

        System.out.println("After removing head: " + pq);
    }
}