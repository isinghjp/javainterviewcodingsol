package com.codesmentors.interview;
//Write a Java method that takes a String as input and 
//returns the first non-repeating character. 
//If all characters repeat, return a special value (e.g., null or ''). 
//Optimize for time and space. Provide code and explain your approach.

import java.util.HashMap;
import java.util.Map;

public class ReturnFirstNonRepeating {
	public static void main(String[] words){
	 }
	  public static Character firstNonRepeatingChars(String str){
	  Map<Character, Integer> map =new HashMap<>();
		
		for(char ch : str.toCharArray()){
		  map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for(char ch : str.toCharArray()){
		  if(map.get(ch) == 1){
			return ch;
		  }
		}
		return null;
	  }

}
