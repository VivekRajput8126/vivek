package com.concurrent.p1;

import java.text.BreakIterator;
import java.util.*;

public class Jtc2 {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		myList = Collections.synchronizedList(myList);
		myList.add(23);
		myList.add(45);
		myList.add(58);
		myList.add(34);
		myList.add(35);
		Iterator<Integer> iterator = myList.iterator();
		while (iterator.hasNext()) {

			System.err.println(iterator.next());
		}
		Vector<Integer> vector = new Vector<>();
		vector.add(23);
		vector.add(54);
		vector.add(47);
		vector.add(45);
		vector.add(90);
		vector.add(29);
		int size = vector.size();

		/*
		 * Iterator<Integer> iterator2 = vector.iterator();
		 * 
		 * while (iterator2.hasNext()) {
		 * 
		 * System.out.println(iterator2.next()); }
		 */

		Enumeration<Integer> enumeration = vector.elements();
		vector.add(20);
		while (enumeration.hasMoreElements()) {

			System.out.println(enumeration.nextElement());
			if (vector.size() == size) {
				break;
			}
		}

	}
}
