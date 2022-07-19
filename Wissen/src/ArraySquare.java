import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class ArraySquare {
	
	public static void main(String[] args) {
		
//		int[][] arr=new int[][] {{2,3},{4,9}};
		
		
		
//		int[] a=new int[] {1,2,3,4,5,6};
//		int k=3;
		
//		for(int i=0;i<a.length;i++) {
//			for(int j=i;j<a.length;j++) {
//				if(Math.abs(a[i]-a[j])==k) {
//					System.out.println(a[i]+","+a[j]);
//				}
//			}
//		}
		
		
		
		
		
		
		
		String str="Be not afraid of greatness, some are born great, "
				+ "some achieve greatness, and some have greatness thrust upon the";
		
		TreeSet<String> result=new TreeSet<>(); 
		int max=0;
		
		String pqr=str.replaceAll(",", "");
		String[] abc=pqr.split(" ");
		for(int i=0;i<abc.length;i++) {
			if(abc[i].length()>max && abc[i].length()%2==0) {
				max=abc[i].length();
				result.add(String.valueOf(abc[i]));
			}
			
		}
		
		System.out.println(result.last());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		for(int i=0;i<arr.length;i++) {
//			int res=arr[i][1]-arr[i][0];
//			System.out.println(res);
//			
//		}
	}

}
