package BinarySearch;

public class BinarySearch {
	
	    public int search(int[] nums, int target) {
	        int low=0;
	        int result=-1;
	        int high=nums.length-1;
	        
	        while(low<high){
	            int mid=(high+low)/2;
	           if(target<nums[mid]){
	               high=mid;
	           }else{
	               low=mid;
	           }
	            
	            if(target==nums[mid]){
	                result=mid;
	            	break;
	            }
	            
	       }
	        return result;
	    }
	    
	    public static void main(String[] args) {
			BinarySearch bs=new BinarySearch();
			int[] nums= {-1,0,3,5,9,12};
			int target=9;
			int result=bs.search(nums, target);
			System.out.println(result);
		}
}
