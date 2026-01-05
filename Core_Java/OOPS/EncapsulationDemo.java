package com.jatin.oops;

// Employee class demonstrating Encapsulation
class Employee {

	// private fields (data hiding)
	private int id;
	private String firstName;

	// Constructor (initialization using this keyword)
	public Employee(int id, String firstName) {
		this.id = id;
		this.firstName = firstName;
	}

	// Public getter for id
	public int getId() {
		return id;
	}

	// Public setter for id (controlled access)
	public void setId(int id) {
		this.id = id;
	}

	// Public getter for lastName
	public String getFirstName() {
		return firstName;
	}

	// Public setter for lastName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}

// Main class
public class EncapsulationDemo {
	public static void main(String[] args) {

		Employee emp1 = new Employee(101, "Jatin");
		Employee emp2 = new Employee(102, "Abhi");

		System.out.println("Employee 1 ID: " + emp1.getId());
		System.out.println();
		System.out.println("Employee 1 First Name: " + emp1.getFirstName());
		System.out.println();

		System.out.println("Employee 2 ID: " + emp2.getId());
		System.out.println();
		System.out.println("Employee 2 First Name: " + emp2.getFirstName());
		System.out.println();

		// Updating data using setters
		emp1.setFirstName("Rahul");
		System.out.println("Updated Employee 1 First Name: " + emp1.getFirstName());
	}
}
