package strings.array;

import java.util.HashSet;
import java.util.Set;

public class StringMininmumUniqueSubstring {

	public static void main(String[] args) {
		String s="pwwkew";
		if(s.length()==0) {
			System.out.println("empty string");
			System.exit(0);;
		}
		int max_len=1;
		Set<Character> uniqueSubStrings=new HashSet<Character>();
		for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++) {
            	String subString=s.substring(i,j);
            	char[] stringArr=subString.toCharArray();
            	for(int k=0;k<stringArr.length;k++){
            		uniqueSubStrings.add(stringArr[k]);
            	}
            	if(max_len<uniqueSubStrings.size()) {
            		max_len=uniqueSubStrings.size();
            		System.out.println(max_len+"  "+uniqueSubStrings.toString());
            	}
            	
            }
			
            
        }
		 
		System.out.println(max_len);
		
	}
}
