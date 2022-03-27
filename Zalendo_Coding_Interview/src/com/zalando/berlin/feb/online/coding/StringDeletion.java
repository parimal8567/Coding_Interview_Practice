package com.zalando.berlin.feb.online.coding;

public class StringDeletion {

	
	public int solution(String S, int[] C) {
		
		int sum=0;
		for(int i=0;i<S.length()-1;i++) {
			// if adjecent characters are same
			if(S.charAt(i)==S.charAt(i+1)) {
				if(C[i]<C[i+1])
					sum=sum+C[i];
				else
					sum=sum+C[i+1];	
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		StringDeletion sd=new StringDeletion();
		
		String input="ababa";
		int[] costs={10,5,10,5,10};
		
		String input1="";
		int[] costs1={};
		
		
		int result=sd.solution(input1, costs1);
		System.out.println(result);
	}
}
