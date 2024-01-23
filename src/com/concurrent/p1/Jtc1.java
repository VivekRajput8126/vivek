package com.concurrent.p1;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Jtc1 {
	public static void main(String[] args) {
		// java.util.collection type object...
		List<String> myList = new ArrayList<>();
		myList.add("Vivek");
		myList.add("Shakib");
		myList.add("Arun");
		myList.add("Preeti");
		myList.add("Praveen");

		Iterator<String> itr = myList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			//myList.add("Shivani");// ConcurrentModificationException
		}

		Vector<String> myVector = new Vector<>();

		myVector.add("Vivek");
		myVector.add("Shakib");
		myVector.add("Praveen");
		myVector.add("Arun");

		ListIterator<String> listIterator = myVector.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
			// myVector.add("Preeti");ConcurrentModificationException
		}

		// Using ConcurrentApi's
		System.err.println("=============Concurrent================");
		List<String> conList = new CopyOnWriteArrayList<>();
		conList.add("Vivek");
		conList.add("Praveen");
		conList.add("Shakib");

		Iterator<String>conIterator = conList.iterator();
		conList.add("Arun");
		conList.remove("Praveen");
		while(conIterator.hasNext()) {
			
			System.out.println(conIterator.next());//Here won't get the ConcurrentModificationException
		}
		System.err.println("Concurrent Set");
		Set<Integer> set = new CopyOnWriteArraySet<>();//Alternate option of SetType in ConcurrentApi
		set.add(33);
		set.add(43);
		set.add(45);
		set.add(33);
		System.out.println(set);
		System.err.println("Concurrent map");
		Map<String, Integer> map= new ConcurrentHashMap<>();
		map.put("Vivek", 1);
		map.put("Shakib", 3);
		map.put("Arun", 23);
		System.out.println(map);
	}
}
