package com.zalando.berlin.jul2.online.coding;

public class Problem3 {
	
	
	int solution(String A) {
        if(null==A || A.isEmpty())
        	return 0;
		int size=A.length();
		int[] lps=new int[size];
		int i=0, j=1;
		lps[0]=0;
		
		while(j<size) {
			if(A.charAt(i)==A.charAt(j)) {
				lps[j]=i+1;
				i++;
				j++;
			}else {
				if(i==0) {
					lps[j]=0;
					j++;
				}else {
					i=lps[i-1];
				}
					
			}
		}
		
		return lps[size-1];
//		for(int i=0,j=A.length()-1;i<A.length();i++,j--) {
//			if(A.charAt(i)==A.charAt(j))
//				
//		}
		
    }
	
	public static void main(String[] args) {
		Problem3 pb3=new Problem3();
		String a="abbabba";
		String b="codility";
		System.out.println(pb3.solution(b));
	}

}
