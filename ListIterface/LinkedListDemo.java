package com.jatin;

import java.util.*;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList<>();
		l1.add(774);
		l1.add(152);
		l1.add(920);
		l1.add(234);
		l1.add(102);
		System.out.println(l1);
		System.out.println(l1.add(45));
		System.out.println(l1);
		System.out.println(l1.clone());
		System.out.println(l1.get(1));
		System.out.println(l1.getFirst());
		System.out.println(l1.getLast());
		System.out.println(l1.offer(4500));
		l1.addLast(74);
		System.out.println(l1);
	}
}
