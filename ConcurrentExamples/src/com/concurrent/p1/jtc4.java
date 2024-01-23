package com.concurrent.p1;

import java.util.Arrays;

public class jtc4 {
	public static void main(String[] args) {
		String string="debit".toLowerCase();
		String check="bited".toLowerCase();
		
		char ch[]=check.toCharArray();
		char ch1[]=string.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch);
		
		System.err.println(Arrays.toString(ch));
		System.err.println(Arrays.toString(ch1));
		boolean status=Arrays.equals(ch, ch1);
		if(!status) {
			System.out.println(string+" not a anagram...");
		}else {
			System.out.println(string+" is a anagram...");
		}
	
	}
}
