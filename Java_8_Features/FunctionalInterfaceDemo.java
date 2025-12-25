package com.jatin.java8;

/*
 * Functional Interface Example (Java 8)
 * ------------------------------------
 * ✔ Only ONE abstract method allowed
 * ✔ Can have default methods
 * ✔ Can have static methods
 * ✔ Supports Lambda Expressions
 */

@FunctionalInterface
interface Calculator {

	// Single Abstract Method (SAM)
	int calculate(int a, int b);

	// Default method (allowed)
	default void info() {
		System.out.println("Functional Interface using Java 8");
	}

	// Static method (allowed)
	static void version() {
		System.out.println("Java Version : 8+");
	}
}

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {

		// Lambda expression implementations
		Calculator add = (a, b) -> a + b;
		Calculator subtract = (a, b) -> a - b;
		Calculator multiply = (a, b) -> a * b;

		System.out.println("Addition       : " + add.calculate(10, 5));
		System.out.println("Subtraction    : " + subtract.calculate(10, 5));
		System.out.println("Multiplication : " + multiply.calculate(10, 5));

		// Calling default & static methods
		add.info();
		Calculator.version();
	}
}
