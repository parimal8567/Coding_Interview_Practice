package ArrayProblems;


/*
 * Given an array of distinct elements and a number x, 
 * find if there is a pair with product equal to x.
 */
public class PairIsProduct {

	public static void main(String[] args) {
		
		Integer[] arr= {3,4,8,2,1};
		int product=4;
		boolean pairFound=false;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]*arr[j]==product) {
					System.out.println("Pair found- "+arr[i]+", and "+arr[j]);
					pairFound=true;
					break;
				}
			}
		}
		
		if(!pairFound) {
			System.out.println("No such pair found!!!");
		}
	}
}
