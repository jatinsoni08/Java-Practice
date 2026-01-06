package com.jatin.oops.multipleInheritence;

// Multiple inheritance using interfaces
public class Car implements Engine, MusicSystem {

	@Override
	public void start() {
		System.out.println("Engine started");
	}

	@Override
	public void playMusic() {
		System.out.println("Music playing");
	}

	public static void main(String[] args) {
		Car car = new Car();
		System.out.println("Multiple Inheritence : \n");
		car.start();
		car.playMusic();
	}
}
