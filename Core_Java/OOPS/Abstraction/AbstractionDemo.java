package com.jatin.oops.abstraction;

//Abstract class
abstract class GraphicObject {

 int x, y;

 void moveTo(int newX, int newY) {
     this.x = newX;
     this.y = newY;
     System.out.println
     ("Moved to position (" + x + ", " + y + ")");
 }

 // abstract methods
 abstract void draw();
 abstract void resize();
}

//Subclass Circle
class Circle extends GraphicObject {

 @Override
 void draw() {
     System.out.println("Drawing Circle");
 }

 @Override
 void resize() {
     System.out.println("\nResizing Circle");
 }
}

//Subclass Rectangle
class Rectangle extends GraphicObject {

 @Override
 void draw() {
     System.out.println("\nDrawing Rectangle");
 }

 @Override
 void resize() {
     System.out.println("\nResizing Rectangle");
 }
}

//Demo class
public class AbstractionDemo {
 public static void main(String[] args) {

     GraphicObject obj1 = new Circle();
     GraphicObject obj2 = new Rectangle();

     obj1.draw();
     obj1.resize();

     obj2.draw();
     obj2.resize();
 }
}

