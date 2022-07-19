package com.zalando.berlin.jul.online.coding;

public class Problem1 {
	
	    int solution(int[] A, int X) {
	        int N = A.length;
	        
	        if (N == 0) {
	            return -1;
	        }
	        
	        int l = 0;
	        int r = N - 1;
	        while (l < r) {
	        	
	            int m = (l + r) / 2;
	            
	            if(A[m]==X) 
		        	return m;
		        
	            if (A[m] > X) {
	                r = m - 1;
	            } else {
	                l = m+1;
	            }
	            
	            
	        }
	        if(A[l]==X)
	        	return l;
	        
	        
	        
	        return -1;
	    }

	
	public static void main(String[] args) {
		
		Problem1 p1=new Problem1();
		
		int[] A=new int[] {1,2,5,9,9};
		int[] B=new int[] {-4,1,2,4,5,6,78,90};
		int[] C=new int[] {-6, -5, -3, -2, 0, 60000, 90000, 100000};
		int[] D=new int[] {-3,-4,-5,-6,0,60000,90000,100000};
		
		int result=p1.solution(D, -6);
		System.out.println("Result-"+result);
		
	}
}
