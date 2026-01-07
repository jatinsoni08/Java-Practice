package com.jatin.oops.polymorphism;

public class TestPolymorphism {
	public static void main(String[] args) {

		Bicycle b1 = new Bicycle(1, 10);
		Bicycle b2 = new MountainBike(3, 15, "Dual");
		Bicycle b3 = new RoadBike(5, 20, 23);

		b1.printDescription();
		b2.printDescription();
		b3.printDescription();
	}
}