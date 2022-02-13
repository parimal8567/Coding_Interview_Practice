package array.searching;

import java.util.ArrayList;
import java.util.List;

public class FindSecondlargetElement {

	
	
	public int secondLargestElement(List<Integer> list) {
		
		int max=Integer.MIN_VALUE, secondMax=Integer.MIN_VALUE;
		for(Integer no:list) {
			if(no>max) {
				secondMax=max;
				max=no;
			}
			if(no>secondMax && no!=max) {
				System.out.println("in between");
				secondMax=no;
			}
		}
		return secondMax;
	}
	
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		
		list.add(10);
		list.add(2);
		list.add(30);
		list.add(20);
		list.add(19);
		list.add(37);
		
		FindSecondlargetElement sle=new FindSecondlargetElement();
		int secondLargestElement=sle.secondLargestElement(list);
		System.out.println(secondLargestElement);
	}
}
