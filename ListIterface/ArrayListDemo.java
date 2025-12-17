package com.jatin;
import java.util.*;
public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(100);
		al.add(45);
		al.add(89);
		al.add(44444);
		System.out.println(al);
		ArrayList al1 = new ArrayList();
		al1.add(100);
		al1.add(45);
		al1.add(12.547);
		System.out.println(al1);
		List l = Collections.unmodifiableList(al1);
		// l.add(7);
		System.out.println(l);
//		l.add(7);
		Iterator<Integer> i = al.iterator();
		while (i.hasNext()) {
			if (i.next() == 100) {
				i.remove();
			}
		}
		System.out.println(al);
	}
}
