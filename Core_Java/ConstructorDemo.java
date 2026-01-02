package com.jatin;

/*
 * Constructor Interview Questions – Practical Proof
 *
 * 1. Can constructors be private?        -> YES
 * 2. Can constructors be overloaded?     -> YES
 * 3. Can constructors be final?          -> NO
 * 4. Is constructor inherited?           -> NO
 */

class Students_1 {

	int id;
	String name;

	// 1️ No-argument constructor
	Students_1() {
		System.out.println("No-arg constructor called");
	}

	// 2️ Parameterized constructor
	Students_1(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("Parameterized constructor called");
	}

	// 3️ Private constructor
	// YES, constructor can be private
	// Object CANNOT be created directly from outside this class
	private Students_1(int id) {
		this.id = id;
		System.out.println("Private constructor called");
	}

	// Static factory method
	// Object creation is controlled here
	public static Students_1 createStudent(int id) {
		return new Students_1(id); // ✅ Allowed (inside same class)
	}

	void display() {
		System.out.println("Id: " + id + ", Name: " + name);
	}

	/*
	 * ❌ Constructors cannot be final
	 * Un-commenting below code will cause compile-time error
	 *
	 * final Students_1() {
	 * }
	 */
}

// Child class to prove constructor is NOT inherited
class CollegeStudent extends Students_1 {

	CollegeStudent() {
		super(); // calling parent constructor
		System.out.println("Child class constructor called");
	}
}

public class ConstructorDemo {

	public static void main(String[] args) {

		System.out.println("---- No-arg constructor ----");
		Students_1 s1 = new Students_1();

		System.out.println("\n---- Parameterized constructor ----");
		Students_1 s2 = new Students_1(1, "Jatin");
		s2.display();

		System.out.println("\n---- Private constructor ----");

		// NOT ALLOWED – uncomment to see compile-time error
		// Students_1 s3 = new Students_1(2);

		// ALLOWED – object created via factory method
		Students_1 s3 = Students_1.createStudent(2);
		s3.display();

		System.out.println("\n---- Constructor inheritance check ----");
		CollegeStudent cs = new CollegeStudent();
	}
}
