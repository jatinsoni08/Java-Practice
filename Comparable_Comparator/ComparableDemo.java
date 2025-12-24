package com.jatin.stream;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Target Class
 * Employee1 class implements Comparable<Employee1>
 * Comparable is used when we want NATURAL SORTING
 * Sorting logic is written INSIDE the class itself
 */
class Employee1 implements Comparable<Employee1> {
	int age;
	String name;
	double sal;

	// Constructor to initialize Employee object
	public Employee1(int age, String name, double sal) {
		this.age = age;
		this.name = name;
		this.sal = sal;
	}

	/*
	 * toString() method
	 * Automatically called when object is printed
	 * Helps in readable output
	 */
	@Override
	public String toString() {
		return "Employee1 [age=" + age + ", name=" + name + ", sal=" + sal + "]";
	}

	/*
	 * compareTo() method
	 * This method defines the NATURAL ORDER of objects
	 *
	 * Rules:
	 * return +ve  -> current object is greater
	 * return -ve  -> current object is smaller
	 * return 0    -> both objects are equal
	 *
	 * Here sorting is based on salary
	 */
	@Override
	public int compareTo(Employee1 o) {
		if (this.sal > o.sal) {
			return 1;

		} else {
			return -1;
		}
	}
}

public class Comparabllee {
	public static void main(String[] args) {

		// Creating ArrayList to store Employee1 objects
		ArrayList<Employee1> al1 = new ArrayList<Employee1>();

		// Creating Employee objects
		Employee1 e1 = new Employee1(15, "Vansh", 20000.00);
		Employee1 e2 = new Employee1(20, "Jatin", 15000.00);
		Employee1 e3 = new Employee1(18, "DAksh", 80000.00);

		// Adding Employee objects into ArrayList
		al1.add(e1);
		al1.add(e2);
		al1.add(e3);

		// Printing list BEFORE sorting
		System.out.println("BEFORE sorting : "+al1);

		/*
		 * Collections.sort(al1)
		 * Uses compareTo() method internally
		 * Sorting happens according to NATURAL ORDER
		 * defined in Employee1 class
		 */
		Collections.sort(al1);

		// Printing list AFTER sorting
		System.out.println("After sorting : "+al1);

	}
}
