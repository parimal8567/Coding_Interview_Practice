package com.paytm.online.coding;

public class Problem2 {
	
	public int solution(int[] nums) {
		int max=Integer.MIN_VALUE;
        int sum=nums[0];
        int j=1;
        int i=0;
        while(i<=j){
        	System.out.println("Max="+max);
            if(j==nums.length-1){
                sum=sum-nums[i];
                i++;
            }else{
                sum=sum+nums[j];
                j++;
            }
            if(max<sum)
                max=sum;
            
        }
        
        return max;
    }
	
	
	public static void main(String[] args) {
		
		Problem2 pb2=new Problem2();
		int[] arr=new int[] {-2,1,-3,4,-1,2,1,-5,4};
		pb2.solution(arr);
		
	}

}
