package Recurssion;

public class BubbleSortRecurssion {

	public int[] bubbleSort(int arr[],int n) {
		if(n==0)
		{
			return arr;
		}
		for(int i=0;i<n-1;i++) {
			if(arr[i]>arr[i+1]) {
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		return bubbleSort(arr,n-1);
	}
	
	public static void main(String[] args) {
		BubbleSortRecurssion br=new BubbleSortRecurssion();
		int[] a= {6,5,4,3,2};
		System.out.println("Before sort:");
		for(int token:a)
		{
			System.out.println(token);
		}
		br.bubbleSort(a, a.length);
		System.out.println("-------------------");
		System.out.println("After sort:"+a.toString());
		for(int token:a)
		{
			System.out.println(token);
		}
	}
}
