package com.jatin.java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamJava8 {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 2, 7, 8, 9, 10);

		// filter() → selects elements based on Predicate
		System.out.println("filter() : ");
		numbers.stream().filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));
		System.out.println("\n");

		// distinct() → removes duplicates
		System.out.println("distinct() : ");
		numbers.stream().distinct().forEach(i -> System.out.print(i + " "));
		System.out.println("\n");

		// sorted() → sorts elements
		System.out.println("sorted() : ");
		numbers.stream().sorted().forEach(i -> System.out.print(i + " "));
		System.out.println("\n");

		// limit() → restricts number of elements
		System.out.println("limit() : ");
		numbers.stream().limit(5).forEach(i -> System.out.print(i + " "));
		System.out.println("\n");

		// map() → transforms elements
		System.out.println("map() : ");
		numbers.stream().map(i -> i * i).forEach(i -> System.out.print(i + " "));
		System.out.println("\n");

		// collect() → converts stream into List
		System.out.println("collect() : ");
		List<Integer> list = numbers.stream().filter(i -> i > 5).collect(Collectors.toList());
		System.out.println(list);
	}
}
