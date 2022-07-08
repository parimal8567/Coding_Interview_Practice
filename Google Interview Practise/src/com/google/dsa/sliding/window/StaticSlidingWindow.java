package com.google.dsa.sliding.window;


/*
 * This is static window sliding problems
 * When to use- 
 * 		Whenever array of length n is given and asked to find a window of k elemnts to find
 * 
 * example -
 * For the given array arr=[5,3,6,7,8,1] find the subarray of size 3 whose sum is maximum
 * Output- 6,7,8
 * Total RuntimeComplexity = O{K+N-1+K}
 * Runtime Complexity= O{n}
 * SpaceTimeComplexity= O{k}
 * 
 */

public class StaticSlidingWindow {
	
	public static void main(String[] args) {
		
		int[] a=new int[] {5,3,6,7,8,1};
		int k=3;
		int[] subArray=findMaxSumOfSubArr(a,k);
		System.out.print("{");
		for(int i=0;i<subArray.length;i++)
			System.out.print(subArray[i]+",");
		System.out.print("}");
	}

	private static int[] findMaxSumOfSubArr(int[] a, int k) {
		int startIndex=0;
		int sum=0;

		// Initial Window
		for(int i=0;i<k;i++) {
			sum=sum+a[i];
			
		}
		// Run Time Complexity till now=K
		System.out.println(sum);

		for(int i=1,j=k;j<a.length;i++,j++) {
			int temp=sum-a[i-1]+a[j];
			System.out.println(temp);
			if(temp>sum) {
				sum=temp;
				startIndex=i;
			}
			
		}
		// Run Time Complexity till now=K+ N-1
		int[] subArr=new int[k];
		for(int i=0;i<k;i++)
			subArr[i]=a[startIndex+i];
		
		//Run Time Complexity till now=K+ N-1 + K
		return subArr;
	}

}
