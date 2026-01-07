package com.jatin.oops.polymorphism;

public class RoadBike extends Bicycle {

	private int tireWidth;

	public RoadBike(int gear, int speed, int tireWidth) {
		super(gear, speed);
		this.tireWidth = tireWidth;
	}

	@Override
	public void printDescription() {
		super.printDescription();
		System.out.println
		("\nRoadBike tire width: " + tireWidth + "mm");
	}
}