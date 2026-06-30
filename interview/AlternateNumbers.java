package com.codesmentors.interview;

public class AlternateNumbers {

	public static void main(String[] args) {
		int[] a = {23, 40, 42, 10, 30, 40};

        System.out.println("Alternate elements in the array:");

        // Loop with step = 2
        for (int i = 0; i < a.length; i += 2) {
            System.out.print(a[i] + " ");
        }

	}

}
