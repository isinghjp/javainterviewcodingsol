package com.codesmentors.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Write a Java method that, given a List of words, 
//returns a List> grouping all anagrams together. 
//Each inner list should contain words that are anagrams of each other. 
//Explain your approach and optimize for time complexity.

public class ReturnsAList {
	public static List<List<String>> groupAnagrams(List<String> words){
		   Map<String, List<String>> map = new HashMap<>();
		   
		   for(String word : words){
			 char[] chars = word.toCharArray();
			 Arrays.sort(chars);
			 String sortedkey = new String(chars);
			 
			 map.computeIfAbsent(sortedkey, k -> new ArrayList<>()).add(word);
			 
		   }
		   return new ArrayList<>(map.values());
		 }
		  public static void main(String[] args){
		  List<String> words = Arrays.asList("tea","eat","tan","ate");
			System.out.println(groupAnagrams(words));
		  }
}
