package com.zalando.berlin.march.online.coding;

/*
 * Rotate the elements of list by k
 * 
 */
public class RotateList {

	public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
     
		if(A.length==0)
			return A;
		int rotation=0;
     
        while(rotation!=K){
        int temp=A[A.length-1];
        for(int i=A.length-1;i>0;i--){
            A[i]=A[i-1];
        }
        A[0]=temp;
        rotation++;
    }
        return A;
    }
	
	public static void main(String[] args) {
		RotateList s=new RotateList();
		int[] a= {3, 8, 9, 7, 6};
		int k=3;
		int[] result=s.solution(a, k);
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+",");
		
	}
}
