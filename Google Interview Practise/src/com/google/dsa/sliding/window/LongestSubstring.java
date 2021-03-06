package com.google.dsa.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.

 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *   Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstring {
	
	public static void main(String[] args) {
		String s="abcabcbb";
		int ans=longestSubString(s);
		System.out.println("Result-"+ans);
		
	}

	private static int longestSubString(String s) {
		  int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	}

}
