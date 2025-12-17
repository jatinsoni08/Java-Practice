package com.jatin;
import java.util.*;
public class staackk {
	public static void main(String[] args) {
		//insertion order is preserved
		//public class Stack<E> extends Vector<E> 
		//as it extends vector so it is also an dynamic aarray----
		Stack s = new Stack(); // this create an empty stack
		//follow LIFO
		System.out.println(s);
		System.out.println(s.push(45));
		System.out.println(s.push("jatin"));
		System.out.println(s.push(8544));
		System.out.println(s.push("soni"));
		System.out.println(s.push(136));
		System.out.println();
		System.out.println(s);
		System.out.println("-------------------");
		System.out.println(s.peek());
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);
		System.out.println(s.indexOf(45));
		System.out.println(s.indexOf("jatin"));

	}
}
