package March2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Q - 1. A can be remove by adjacent character B 
 * 	   2. C can be removed by adjacent character D
 * 
 * 
 * 
 * 1. CBACD
 * 2. CABABD
 * 3. ACBDACBD
 */

public class PS1 {
	
	
	
	public String solution(String S) {
		
		StringBuilder newString=new StringBuilder();
		
		if(S.length()==0)
			return "";
		
		
//		Map<Character,List<Integer>> chars=new HashMap<>();
//		
//		for(int i=0;i<S.length();i++ ) {
//			char temp=S.charAt(i);
//			if(temp=='A' || temp=='C') {
//				if(null==chars.get(temp)) {
//					List<Integer> indexes=new ArrayList<>();
//					indexes.add(i);
//					chars.put(temp,indexes);
//				}else {
//					List<Integer> indexes= chars.get(temp);
//					indexes.add(i);
//				}
//			}
//		}
		
		boolean[] occurance=new boolean[S.length()];
		
		
		
		
		
		
		for(int i=0; i<S.length();i++) {
			char temp=S.charAt(i);
//			if(S.charAt(i)=='A' || S.charAt(i)=='C') {
				
				
				
				if(temp=='A') {
					
					if(i==0) {
						if(S.charAt(i+1)=='B') {
							occurance[i]=true;
							occurance[i+1]=true;
						}
					}else if( i==S.length()) {
						if(S.charAt(i-1)=='B') {
							occurance[i]=true;
							occurance[i-1]=true;
						}
					}else {
						if(S.charAt(i+1)=='B') {
							occurance[i]=true;
							occurance[i+1]=true;
						}
						
						if(S.charAt(i-1)=='B') {
							occurance[i]=true;
							occurance[i-1]=true;
						}
					}
					
				}
				
				if(temp=='C') {
					
					if(i==0) {
						if(S.charAt(i+1)=='D') {
							occurance[i]=true;
							occurance[i+1]=true;
						}
					}else if( i==S.length()) {
						if(S.charAt(i-1)=='D') {
							occurance[i]=true;
							occurance[i-1]=true;
						}
					}else {
						if(S.charAt(i+1)=='D') {
							occurance[i]=true;
							occurance[i+1]=true;
						}
						
						if(S.charAt(i-1)=='D') {
							occurance[i]=true;
							occurance[i-1]=true;
						}
					}
					
				}
				
				
				
				
				
				
//				if(i==0) {
//					if(S.charAt(i)=='A' && S.charAt(i+1)=='B' || S.charAt(i)=='C' && S.charAt(i+1)=='D') {
//						i++;
//					}
//				} else if(i==S.length()) {
//					if(S.charAt(i)=='A' && S.charAt(i-1)=='B' || S.charAt(i)=='C' && S.charAt(i-1)=='D') {
//						i++;
//					}
//					
//				}else if((S.charAt(i)=='A' && S.charAt(i+1)=='B' || S.charAt(i-1)=='B') || 
//						S.charAt(i)=='C' && S.charAt(i+1)=='D' || S.charAt(i-1)=='D') {
//					i++;
//				}
//				newString.append(S.charAt(i));
				
						
//			}else {
//				newString.append(S.charAt(i));
//			}
		}
		
		
		for(int i=0;i<occurance.length;i++) {
			if(occurance[i]==false) {
				newString.append(S.charAt(i));	
			}
		}
		
		return newString.toString();
		
	}
	
	
	
	public static void main(String[] args) {
		
		PS1 ps=new PS1();
		String s="CABABD";
		String result=ps.solution(s);
		System.out.println(result);
	}

}
