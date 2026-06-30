//Program to illustrate Pure Function Example
package com.codesmentors.interview;

public class PureFunctionExample {
	// Pure function: A function that always produces the same output for the same input and has no side effects.
	public static int add(int a, int b) {
		return a + b;
	}
	public static void main(String[] args) {
		
		System.out.println("Pure Function Example:");
		System.out.println("add(2, 3) = " + add(2, 3)); // Output: 5
		System.out.println(add(2, 3)); // still 5
	}

}
