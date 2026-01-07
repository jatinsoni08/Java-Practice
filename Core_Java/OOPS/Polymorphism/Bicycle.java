package com.jatin.oops.polymorphism;

public class Bicycle {
	int gear;
	int speed;

	public Bicycle(int gear, int speed) {
		this.gear = gear;
		this.speed = speed;
	}

	public void printDescription() {
		System.out.println
		("\nBike in gear " + gear + " at speed " + speed);
	}
}