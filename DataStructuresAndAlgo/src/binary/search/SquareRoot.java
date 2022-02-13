package binary.search;

public class SquareRoot {

	 public int mySqrt(int x) {
	        int sqrt=1;
	        if(x<2){
	            return x;
	        }
	        for(int i=2;i<=x/2;i++) {
	        	long product=i*i;
	        	if(product>x) {
	        		return i-1;
	        	}else if(product<x) {
	        		return i+1;
	        	}else {
	        		return i;
	        	}
	        }
	        
	       
	        return sqrt;
	    }
	 
	 public int mySqrtBinarySearch(int x) {
		 if (x < 2) return x;

		    long num;
		    int pivot, left = 2, right = x / 2;
		    while (left <= right) {
		      pivot = left + (right - left) / 2;
		      num = (long)pivot * pivot;
		      if (num > x) right = pivot - 1;
		      else if (num < x) left = pivot + 1;
		      else return pivot;
		    }

		    return right;
	 }
	 
//	 public int guessNumber(int n) {
//	        int low = 1;
//	        int high = n;
//	        while (low <= high) {
//	            int mid = low + (high - low) / 2;
//	            int res = guess(mid);
//	            if (res == 0)
//	                return mid;
//	            else if (res < 0)
//	                high = mid - 1;
//	            else
//	                low = mid + 1;
//	        }
//	        return -1;
//	    }
	
	public static void main(String[] args) {
		SquareRoot sr=new SquareRoot();
		int result=sr.mySqrt(5);
		System.out.println(result);
		int result1=sr.mySqrtBinarySearch(5);
		System.out.println(result1);
	}
}
