package com.jatin;
/*
 * Student class
 * This is a user-defined class.	
 * Every class in Java implicitly extends java.lang.Object.
 */
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name; 
    }
    /*
     * Overriding toString() method
     * This method is called implicitly when an object is printed.
     * Default implementation from Object class prints:
     * ClassName@HexadecimalHashCode
     * Overriding it gives meaningful output.
     */
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
    /*
     * Overriding equals() method
     * == compares reference (memory location)
     * equals() is used for content comparison
     * Here, we compare Student objects based on id and name
     */
    @Override
    public boolean equals(Object obj) {

        // If both references point to the same object
        if (this == obj)
            return true;

        // If object is null or classes are different
        // Prevents NullPointerException
        // Ensures the object is actually a Student
        if (obj == null || getClass() != obj.getClass())
            return false;

        Student s = (Student) obj;

        return id == s.id && name.equals(s.name); 
    }
    /*
     * Overriding hashCode() method
     * If equals() is overridden, hashCode() must also be overridden.
     * Equal objects must return the same hash code.
     * This method is heavily used in HashMap and HashSet.
     */
    @Override
    public int hashCode() {
        return id * 31 + name.hashCode();
    }
}

public class ObjectClassDemo {

    public static void main(String[] args) {

        Student s1 = new Student(1, "Jatin");
        Student s2 = new Student(1, "Jatin");

        /*
         * toString() method call
         * Called implicitly by println()
         */
        System.out.println("toString(): " + s1);
        
        /*
         * equals() method
         * Compares object content
         */
        System.out.println("equals(): " + s1.equals(s2));

        /*
         * == operator
         * Compares object references (memory locations)
         */
        System.out.println("== operator: " + (s1 == s2));

        /*
         * hashCode() method
         * Equal objects should have same hash code
         */
        System.out.println("hashCode of s1: " + s1.hashCode());
        System.out.println("hashCode of s2: " + s2.hashCode());

        /*
         * getClass() method
         * Returns runtime class information
         */
        System.out.println("getClass(): " + s1.getClass());
    }
}
