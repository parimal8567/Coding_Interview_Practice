package array.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSortAlgo {
	
	
	public static void mergeSort(List<Integer> list){
		int[] array=new int[list.size()];
		int k=0;
		for(Integer no:list) {
				array[k]=no;
				k++;
		}
		mergeSort(array, new int[array.length],0, array.length-1);
		
		for(int m=0;m<array.length;m++)
			System.out.print(array[m] + " ");
		System.err.println();
	}
	
	public static void mergeSort(int[] array, int[] temp,int leftStart, int rightEnd) {
		if(leftStart>=rightEnd)
			return;
		
		int middle=(leftStart+rightEnd)/2;
		
		mergeSort(array, temp, leftStart, middle);
		mergeSort(array, temp, middle+1, rightEnd);
		merge(array,temp,leftStart,rightEnd);
	}
	
	public static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {
		int leftEnd=(leftStart+rightEnd)/2;
		int rightStart=leftEnd+1;
		int size=rightEnd-leftStart+1;
		
		int left=leftStart;
		int right=rightStart;
		int index=leftStart;
		
		while(left<=leftEnd && right <= rightEnd) {
			
			if(array[left]<= array[right]) {
				temp[index]=array[left];
				left++;
			}else {
				temp[index]=array[right];
				right++;
			}
			index++;
		}
				
		System.arraycopy(array, left, temp, index, leftEnd-left+1);
		System.arraycopy(array, right, temp, index, rightEnd-right+1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
		
				
				
	}
	
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<Integer>();
		list.add(10);
		list.add(2);
		list.add(30);
		list.add(20);
		list.add(19);
		list.add(37);
		
		MergeSortAlgo ms=new MergeSortAlgo();
		ms.mergeSort(list);
		
		System.out.println("List="+list.toString());
		
		
	}

}
