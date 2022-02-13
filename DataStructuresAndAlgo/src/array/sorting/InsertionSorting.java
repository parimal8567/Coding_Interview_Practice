package array.sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertionSorting {

	public List<Integer> insertionSorted(List<Integer> list){
		int[] a=new int[list.size()];
		int k=0;
		for(Integer no:list) {
				a[k]=no;
				k++;
		}
		
		for(int i=1;i<a.length;i++) {
			int valueToSort=a[i];
			int j;
			for( j=i;j>0 && a[j-1]>valueToSort;j--) {
				a[j]=a[j-1];
			}
			a[j]=valueToSort;
		}
		
		
		List<Integer> sortedList=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			sortedList.add(a[i]);
		}
		return sortedList;
	}
	
	public static void main(String[] args) {
		InsertionSorting is=new InsertionSorting();
		
		List<Integer> list= new ArrayList<Integer>();
		list.add(10);
		list.add(2);
		list.add(30);
		list.add(20);
		list.add(19);
		list.add(37);
		List<Integer> sortedList=is.insertionSorted(list);
		System.out.println(sortedList.toString());
		
	}
	
}
