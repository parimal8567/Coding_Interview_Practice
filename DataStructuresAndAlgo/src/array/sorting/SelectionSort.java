package array.sorting;

import java.util.List;
import java.util.ArrayList;

public class SelectionSort {

	public List<Integer> selectionSort(List<Integer> list){
		int[] a=new int[list.size()];
		int k=0;
		for(Integer no:list) {
				a[k]=no;
				k++;
		}
		
		for(int i=0;i<a.length;i++) {
			int index=i;
			
			for(int j=i+1;j<a.length;j++) {
//				if(a[j]<a[index]) {
//					index=j;
//					int smallerNumber=a[index];
//					a[index]=a[i];
//					a[i]=smallerNumber;
//				}
				
				if(a[j]<a[i]) {
					int temp=a[j];
					a[j]=a[i];
					a[i]=temp;
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
		SelectionSort ss=new SelectionSort();
		List<Integer> list= new ArrayList<Integer>();
		list.add(40);
		list.add(2);
		list.add(30);
		list.add(20);
		list.add(19);
		list.add(37);
		
		List<Integer> sortedList=ss.selectionSort(list);
		System.out.println(sortedList.toString());
	}
}
