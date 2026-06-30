//Pure Function using Java 8 Stream API
package com.codesmentors.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PureFunctionStream {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		//Pure Function : map(x -> x * 2) does not depend on external state
		List<Integer> doubled=numbers.stream()
				.map(x -> x * 2) // Pure function
				.collect(Collectors.toList());
		System.out.println(doubled); // Output: [2, 4, 6, 8, 10]
	}

}
