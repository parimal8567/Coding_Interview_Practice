package com.google.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a library which will take the values and replaces in the given input string
 * Example 1
 * X-> 123
 * Y-> 456
 * 
 * Input -> %X%_%Y% 
 * Output -> 123_456
 *
 * Example 2
 * USER -> admin
 * PASSWORD -> password
 * HOME -> /app/web/abc
 * PORT -> 8080
 * 
 * Input -> %HOME%/usr/123/%USER%.txt
 * Output -> /app/web/abc/usr/123/admin.txt
 */

public class PlaceHolderReplacement {

	public static void main(String[] args) {
	
		Map<String,String> values=new HashMap<>();
		values.put("USER", "admin");
		values.put("PASSWORD", "password");
		values.put("HOME", "/app/web/abc/%PORT%");
		values.put("PORT", "8080");
		String input="%HOME%/usr/123/%USER%.txt";
		String s=replacePlaceholders(values, input);
		System.out.println("Result="+s);
	}

	private static String replacePlaceholders(Map<String, String> values, String input) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)=='%') {
				StringBuilder tempSb=new StringBuilder();
				int j=i+1;
				while(input.charAt(j)!='%') {
					tempSb.append(input.charAt(j));
					j++;
				}
				sb.append(values.get(tempSb.toString()));
				i=j;
			}else {
				sb.append(input.charAt(i));
			}
		}
		System.out.println(sb.toString());
		String a=sb.toString();
		while(a.contains("%"))
			a=replacePlaceholders(values,sb.toString());
		
		return a;
		
		
		
		
		
		
	}
	
	
}
