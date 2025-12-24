package com.jatin.stream;

import java.util.*;

/*
 * Employee class
 * No sorting logic is written here.
 * Comparator will handle sorting externally.
 */
class Employee {
	int age;
	String name;
	double sal;

	// Constructor to initialize Employee object
	public Employee(int age, String name, double sal) {
		this.age = age;
		this.name = name;
		this.sal = sal;
	}

	/*
	 * toString() method
	 * Automatically called when object is printed
	 */
	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", sal=" + sal + "]";
	}
}

/*
 * A01 class implements Comparator<Employee>
 * This is one way of writing Comparator using a separate class
 * Sorting logic is based on salary
 */
class A01 implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {

		/*
		 * compare() method rules:
		 * return +ve  -> o1 > o2
		 * return -ve  -> o1 < o2
		 * return 0    -> both equal
		 */
		if (o1.sal > o2.sal) {
			return 1;

		} else {
			return -1;
		}
	}
}

public class ComparatorDemo {
	public static void main(String[] args) {

		// Creating ArrayList to store Employee objects
		ArrayList<Employee> al = new ArrayList<Employee>();

		// Creating Employee objects
		Employee e1 = new Employee(15, "Vansh", 20000.00);
		Employee e2 = new Employee(20, "Jatin", 15000.00);
		Employee e3 = new Employee(18, "DAksh", 80000.00);

		al.add(e1);
		al.add(e2);
		al.add(e3);

		System.out.println("Before Sort : "+al);
		System.out.println();

		/*
		 * Anonymous Inner Class implementation of Comparator
		 * Used before Java 8
		 * Sorting logic written at the time of use
		 */
		
//		Comparator<Employee> ee = new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				if (o1.sal > o2.sal) {
//					return 1;
//
//				} else {
//					return -1;
//				}
//
//			}
//		};

		/*
		 * Lambda Expression implementation of Comparator (Java 8+)
		 * Comparator is a Functional Interface
		 * Hence lambda expression is allowed
		 */
		Comparator<Employee> ee = (Employee o1, Employee o2)-> {
			if (o1.sal > o2.sal) {
				return 1;

			} else {
				return -1;
			}
		};

		// Sorting ArrayList using Comparator
		Collections.sort(al, ee);

		// Printing list after sorting
		System.out.println("After Sort : "+al);
	}
}
