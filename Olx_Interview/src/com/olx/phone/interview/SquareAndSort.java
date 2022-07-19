package com.olx.phone.interview;

public class SquareAndSort {
	
	
	 public static int[] sortedSquares(int[] nums) {
	        int left=0;
	        int right=nums.length-1;
	        
	        while(left<nums.length && right>=0){
	            if(Math.abs(nums[left])>Math.abs(nums[right]) ) {
	                int temp=nums[left];
	                nums[left]=nums[right];
	                nums[right]=temp;
	                right--;
	            }else{
	               left++;
	               right--;
	            }
	        }
	        for(int i=0;i<nums.length;i++)
	            nums[i]=nums[i]*nums[i];
	        return nums;
	    }
	public static void main(String[] args) {
		SquareAndSort ss= new SquareAndSort();
		int[] input=new int[] {-4,-1,0,3,10};
		int[] result=sortedSquares(input);
		for(int i=0;i<result.length-1;i++)
			System.out.print(result[i]+",");
		System.out.print(result[result.length-1]);
		
	}

}
