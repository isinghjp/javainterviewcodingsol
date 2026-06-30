//Program to illustrate use of Impure Function
package com.codesmentors.interview;

public class ImpureFunctionExample {
	private static int counter=0;
	
	//Impure function: depends on external state
	public static int increment(int value) {
		counter++;
		return value + counter;
	}
	public static void main(String[] args) {
		System.out.println(increment(5)); // Output: 6 result depends on counter
		System.out.println(increment(5)); // Output: 7 different result next time
	}

}
