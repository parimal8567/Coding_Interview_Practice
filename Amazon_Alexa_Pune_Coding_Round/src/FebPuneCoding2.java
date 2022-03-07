
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FebPuneCoding2 {

	public int solution(int[] nums) {
		  
		List<Integer> numList=new ArrayList<>();
		
		long count=getCount(numList);
		
		if(count%2==0) {
			return nums.size();
		}else {
			// If count is odd then find first occurance of -1
			
			Optional<Integer> element=nums.stream().filter(n->n==-1).findFirst();
			int index=nums.indexOf(element.get());
			
			int firstSub=nums.subList(0, index).size();
			
			int secondSub=nums.subList(index+1, nums.size()).size();

			if(firstSub>secondSub) {
				return firstSub;
			}else {
				return secondSub;
			}
			
			
		}
	}
	
	long getCount(List<Integer> nums){
		return nums.stream().filter(n->n==-1).count();
	}
	
	public static void main(String[] args) {
		
		FebPuneCoding2 fc=new FebPuneCoding2();
		List<Integer> nums= new ArrayList<>(Arrays.asList(-1,1,-1,1));
		int res=fc.solution(nums);
		
		System.out.println(res);
	}
}
