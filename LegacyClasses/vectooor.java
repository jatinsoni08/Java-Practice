package com.jatin;
import java.util.*;
public class vectooor {
	public static void main(String[] args) {
		Vector v1 = new Vector();
		//it stores heterogeneous data 
		//follow dynamic array 
		//insertion order is preserved
		
		v1.add(98);
		v1.add(66);
		v1.add("jatin");
		v1.add(412);
		v1.add("soni");
		
		Enumeration ee = v1.elements();
		while(ee.hasMoreElements()) {
			Object o = ee.nextElement();
			System.out.println(o);
		}
		
		Vector v22 = new Vector();
		v22.add(4587);
		v22.add("java");
		v22.add("programming");
		v22.add(22.11);
		v22.add(14.2);
		
		System.out.println(v22); 	
		
		System.out.println("------------------------");
		System.out.println(v1.addAll(v22));
		System.out.println(v1);
		
		System.out.println(v1.clone());
		System.out.println();
		System.out.println(v1.contains(98));
		
		System.out.println();
		System.out.println(v1.elementAt(5));
		
		System.out.println();
		System.out.println(v1.firstElement());
		
		System.out.println();
		System.out.println(v1.getFirst());
		
		System.out.println();
		System.out.println(v1.hashCode());
		
		System.out.println();
		System.out.println(v22.isEmpty());
		
		System.out.println();
		v22.clear();
		System.out.println(v22);
		
		
		
		
		
		
		
		
		
	
		
	}
}
