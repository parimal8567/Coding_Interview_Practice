
public class Solution {

	
	public int run(String s) {
		
		if(Math.abs(Integer.parseInt(s))>9 && Math.abs(Integer.parseInt(s))<99) {
			return Integer.parseInt(s);
		}
		
		
		int maxFragment=0;
		for(int i=0;i<s.length()-1;i++) {
			String fragment=s.substring(i, i+2);
			if(Integer.parseInt(fragment)>maxFragment) {
				maxFragment=Integer.parseInt(fragment);
			}
			
		}
		
		return maxFragment;
		
		
	}
	
	
	public static void main(String[] args) {
		
		Solution sl=new Solution();
		
		// Input
		
		String s="88";
		String s1="0000";
		int result=sl.run(s1);
		System.out.println("Result is "+ result);
		
		
	}
}
