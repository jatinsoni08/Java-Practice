package com.jatin.java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamJava8 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 9, 4, 11, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15);

		// Even Numbers using filter()
		System.out.println("Even Numbers Stream:");
		List<Integer> evenNumbers = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers);

		// Odd Numbers using filter()
		System.out.println("\nOdd Numbers Stream:");
		List<Integer> oddNumbers = numbers.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
		System.out.println(oddNumbers);

		// Remove duplicates using distinct() and forEach()
		System.out.println("\nRemove Duplicate:");
		numbers.stream().distinct().forEach(i -> System.out.print(i + " "));
	}

}
