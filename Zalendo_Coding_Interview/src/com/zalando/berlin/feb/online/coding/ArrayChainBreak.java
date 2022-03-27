package com.zalando.berlin.feb.online.coding;
import java.util.*;
public class ArrayChainBreak {

	public int solution(int[] A) {
		
		List<Integer> results=new ArrayList<>();
		for(int i=0;i<A.length-2;i++) {
			for(int j=i+2;j<A.length;j++) {
				int temp=A[i]+A[j];
				results.add(temp);
			}
			
		}
		Collections.sort(results);
		
		
		return results.get(0);
	}
	
	public static void main(String[] args) {
		ArrayChainBreak acb=new ArrayChainBreak();
		
		int[] arr= {5,2,4,6,3,7};
		int result=acb.solution(arr);
		System.out.println(result);
	}
}
