package com.amazon.amsterdam.phone.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Find the anagram for the given list
 * Input ["stop","post","bat","tab","cat"]
 */
public class SecondRound {
	
	public List<List<String>> getAnagram(String[] strs){
		List<List<String>> output=new ArrayList<>();
		Map<String,List<String>> layout=new HashMap<>();
		
		for(int i=0;i<strs.length;i++) {
			String str=strs[i];
			char[] strTemp=str.toCharArray();
			Arrays.sort(strTemp);
			String sortedString=String.valueOf(strTemp);
			
			char[] charArray=str.toCharArray();
			Arrays.sort(charArray);
			String key=String.valueOf(charArray);
			if(null==layout.get(key)) {
				List<String> value=new ArrayList<>();
				value.add(str);
				layout.put(key, value);
			}else {
				List<String> values=layout.get(key);
				values.add(str);
			}
		}
		
		for(String str:layout.keySet()) {
			output.add(layout.get(str));
		}

		return output;
	}
	
	public static void main(String[] args) {
		SecondRound sr=new SecondRound();
		String[] strs= {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result=sr.getAnagram(strs);
		System.out.println("Result:="+result);
		
	}

}
