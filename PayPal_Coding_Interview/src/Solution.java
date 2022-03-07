import java.util.Scanner;

public class Solution {

	
	public long solution(int l, int r) {
		
		
		
		int sum=l;
		int temp=l;
		int result=0;
		for(int i=l;i<=r;i++) {
			while(Math.abs(sum)>1) {
				sum=0;
				while(temp>0) {
					int digit=temp%10;
					temp=temp/10;
					sum=sum+(digit*digit);
					
				}
				temp=sum;
			}
			if(temp==1)
					result=result+i;
		}
		
		
		
		return result;
	}
	
	public static void main(String[] args) {
		
		
		
		
		
		//Scanner sc= new Scanner(System.in);
		
		Solution s=new Solution();
		long r=s.solution(31,32);
		System.out.println(r);
	
	}
}
