package array.sorting;

import java.util.ArrayList;
import java.util.List;

public class BubbleSorting {

	public List<Integer> bubbleSorted(List<Integer> list){
		int[] a=new int[list.size()];
		int k=0;
		for(Integer no:list) {
				a[k]=no;
				k++;
		}
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length-1-j;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
		
		List<Integer> sortedList=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			sortedList.add(a[i]);
		}
		
		return sortedList;
	}
	
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<Integer>();
		list.add(10);
		list.add(2);
		list.add(30);
		list.add(20);
		list.add(19);
		list.add(37);
		BubbleSorting bs=new BubbleSorting();
		List<Integer> sortedList=bs.bubbleSorted(list);
		System.out.println(sortedList.toString());
		
	}
}
