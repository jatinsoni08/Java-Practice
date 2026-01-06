package com.jatin.oops.relationship_aggragation;

//Aggregation example

public class Department {

 private Teacher teacher; // HAS-A relationship

 public Department(Teacher teacher) {
     this.teacher = teacher;
 }

 public void show() {
     System.out.println("Department has teacher: " + teacher.name);
 }
}