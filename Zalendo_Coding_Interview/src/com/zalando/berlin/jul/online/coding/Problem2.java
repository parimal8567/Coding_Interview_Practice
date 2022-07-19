package com.zalando.berlin.jul.online.coding;

/**
 * 
 * Given an array of integers is the height of a building.
 * All the building has same width, you have to paint the skyline 
 * using horizontal continuous brush strokes. Every stroke is one unit high
 * 
 * Calculate the maximum number of strokes 
 * 
 * Example 1
 * A[0]=5
 * A[1]=8
 * 
 * Output = 8
 * 
 * Example 2
 * A[0]=1
 * A[1]=1
 * A[1]=1
 * A[1]=1
 * 
 * Output = 1
 * 
 *
 */
public class Problem2 {

	 public int solution(int[] A) {
	        int stroke=0;
	        int prevStroke=0;
	        for(int i=0;i<A.length;i++){
	            if(prevStroke < A[i]){
	                stroke=stroke+(A[i]-prevStroke);
	            }
	            prevStroke=A[i];
	        }
	        return stroke;
	    }
	 
	 public static void main(String[] args) {
		Problem2 pb2=new Problem2();
		int[] a=new int[] {1,3,2,1,2,1,5,3,3,4,2};
		int result=pb2.solution(a);
		System.out.println("Result="+result);
	}
}
