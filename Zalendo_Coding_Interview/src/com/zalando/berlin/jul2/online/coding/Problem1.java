package com.zalando.berlin.jul2.online.coding;

public class Problem1 {
	
	int solution(int[] A) {
        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		Problem1 p1=new Problem1();
		int[] a=new int[] {1,2345};
		System.out.println(p1.solution(a));
	}

}
