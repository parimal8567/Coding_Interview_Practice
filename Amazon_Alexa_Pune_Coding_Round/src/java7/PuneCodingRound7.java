package java7;

public class PuneCodingRound7 {

	public int solution(int[] nums) {
		  
		
		// Get all -1 count from array
		int count=getCount(nums);
		
		if(count%2==0) {
			// if number is even product will always be 1
			return nums.length;
		}else {
			// If count is odd then find first occurance of -1 
			//and divide array into 2 subarrays
			int index=0;
			for(int i=0;i<nums.length;i++) {
				if(nums[i]<0) {
					index=i;
					break;
				}
			}
			
			int firstSub=0+index;
			boolean firstSubFlag=ifContainsZero(nums,0,index);
			boolean secondSubFlag=ifContainsZero(nums,index+1,nums.length);
			int secondSub=nums.length-(index);

			if(firstSubFlag && secondSubFlag)
				return 0;
			if(firstSub>secondSub) {
				if(!firstSubFlag)
					return firstSub;
				else
					return secondSub;
			}else {
				if(!secondSubFlag)
					return secondSub;
				else
					return firstSub;
			}
			
			
		}
	}
	
	boolean ifContainsZero(int[] nums, int start,int index) {
		boolean flag=false;
		for(int i=start;i<index;i++) {
			if(nums[i]==0) {
				flag=true;
				break;
						
			}
				
		}
		return flag;
	}
	
	int getCount(int[] nums){
		int count=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<0)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		PuneCodingRound7 fc=new PuneCodingRound7();
		//List<Integer> nums= new ArrayList<>(Arrays.asList(-1,1,-1,1));
		
		
		//[1,-2,-3,4]=4
		//[0,1,-2,-3,-4]=3
		//[-1,-2,-3,0,1]=2
		int[] nums= {-1,-2,-3,0,1};
		int res=fc.solution(nums);
		
		System.out.println(res);
	}
}
