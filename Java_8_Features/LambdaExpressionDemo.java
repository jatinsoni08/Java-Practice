package com.jatin.java8;

//Functional Interface for Even & Odd
@FunctionalInterface
interface I {
	boolean evenOdd(int n);
}

//Functional Interface for Sum of Two Numbers
@FunctionalInterface
interface I2 {
	int sumTwo(int a, int b);
}

public class LambdaExpressionDemo {

	public static void main(String[] args) {

		// Even & Odd using Lambda
		I evenCheck = n -> n % 2 == 0;
		System.out.println(evenCheck.evenOdd(8)); // true

		// Sum of two numbers using Lambda
		I2 sum = (a, b) -> a + b;
		System.out.println(sum.sumTwo(10, 20)); // 30
	}
}
