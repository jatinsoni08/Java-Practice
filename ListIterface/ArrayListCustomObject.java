package com.jatin.ListIterface;

import java.util.ArrayList;

class Employee {
	int empid;
	String name;

	public Employee(int empid, String name) {
		this.empid = empid;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Employee e = (Employee) obj;
		return this.empid == e.empid;
	}
}

public class ArrayListCustomObject {
	public static void main(String[] args) {

		ArrayList<Employee> al = new ArrayList<>();

		al.add(new Employee(1, "Vansh"));
		al.add(new Employee(2, "Jatin"));
		al.add(new Employee(3, "Vivek"));
		al.add(new Employee(4, "Karan"));
		al.add(new Employee(5, "Hitesh"));

		// insert at index
		al.add(4, new Employee(6, "Jatin"));

		// null value allowed
		al.add(new Employee(7, null));

		System.out.println("Last element:");
		System.out.println(al.get(al.size() - 1));

		System.out.println("---------------");

		// Iteration
		for (Employee e : al) {
			System.out.println(e);
		}

		System.out.println("---------------");

		// indexOf uses equals()
		Employee search = new Employee(3, "AnyName");
		System.out.println("Index of empid 3: " + al.indexOf(search));
	}
}
