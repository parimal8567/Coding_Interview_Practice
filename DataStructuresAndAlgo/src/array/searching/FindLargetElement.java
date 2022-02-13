package array.searching;

import java.util.ArrayList;
import java.util.List;

public class FindLargetElement {

	public int largestElement(List<Integer> list) {
	
		int max=Integer.MIN_VALUE;
		for(Integer no:list) {
			if(no>max) {
				max=no;
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		
		list.add(10);
		list.add(2);
		list.add(30);
		list.add(20);
		list.add(19);
		list.add(37);
		
		FindLargetElement le=new FindLargetElement();
		int largestElement=le.largestElement(list);
		System.out.println(largestElement);
	}
}
