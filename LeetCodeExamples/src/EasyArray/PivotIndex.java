package EasyArray;

public class PivotIndex {

	public int pivotIndex(int[] nums) {
        int leftSum=0;
        int rightSum=0;
        int[] leftResult=new int[nums.length];
        int[] rightResult=new int[nums.length];
        leftResult[0]=nums[0];
        rightResult[nums.length-1]=nums[nums.length-1];
        
        for(int i=1,j=nums.length-2;i<nums.length;i++,j--) {
        	leftResult[i]=nums[i]+leftResult[i-1];
            rightResult[j]=nums[j]+rightResult[j+1];
        	
        }
        
        if(rightResult.length>2 && rightResult[1]==0)
        	return 0;
        
//        if(leftResult[nums.length-2]==rightResult[nums.length-1])
//        	return nums.length-1;
        for(int i=1;i<nums.length-1;i++){
            
            if(leftResult[i-1]==rightResult[i+1]){
                return i;
            }
        }
        if(leftResult.length>2 && leftResult[nums.length-2]==0)
        	return nums.length-1;
        return -1;
    }
	
	public static void main(String[] args) {
		PivotIndex pi=new PivotIndex();
//		int[] data=new int[] {1,7,3,6,5,6};
//		int[] data=new int[] {2,1,-1};
//		int[] data=new int[] {1,2,3,6};
//		int[] data=new int[] {-1,-1,-1,1,1,1};
//		int[] data=new int[] {-1,-1,0,1,1,0};
		int[] data=new int[] {0};
		
		int result=pi.pivotIndex(data);
		System.out.println(result);
		
	}
}
