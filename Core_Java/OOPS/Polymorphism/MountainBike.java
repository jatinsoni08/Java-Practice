package com.jatin.oops.polymorphism;

public class MountainBike extends Bicycle {

	private String suspension;

	public MountainBike(int gear, int speed, String suspension) {
		super(gear, speed);
		this.suspension = suspension;
	}

	@Override
	public void printDescription() {
		super.printDescription();
		System.out.println
		("\nMountainBike suspension: " + suspension);
	}
}
