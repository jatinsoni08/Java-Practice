package com.jatin.java8;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<>();
		al.add(45);
		al.add(74);
		al.add(77);
		al.add(4);

		// Predicate Lambda Expression (Even numbers)
		Predicate<Integer> p = i -> i % 2 == 0;

		// Stream + filter + lambda
		al.stream()
		  .filter(p)
		  .forEach(j -> System.out.println(j));
	}
}
