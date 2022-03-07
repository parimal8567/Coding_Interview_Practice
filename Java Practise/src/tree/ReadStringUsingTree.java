package tree;

import java.util.Arrays;

public class ReadStringUsingTree {

//	public static class Node{
//		char val;
//		Node left;
//		Node right;
//	}
//	
	
	void printArr(boolean[][] arr, int n,int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		ReadStringUsingTree ab=new ReadStringUsingTree();
		String str = "baaabab";
        String pattern = "*****ba*****ab";
        int n=str.length();
        int m=pattern.length();
		 // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];
 
        // initialize lookup table to false
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(lookup[i], false);
        
        System.out.println("Printing initial array--");
        ab.printArr(lookup, n, m);
        
        
        // empty pattern can match with empty string
        lookup[0][0] = true;
        System.out.println("Printing second array--");
        ab.printArr(lookup, n, m);
        
        
     // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];
        
        System.out.println("Printing after * check array--");
        ab.printArr(lookup, n, m);
        
        
     // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty
                //     sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1]
                                   || lookup[i - 1][j];
 
                // Current characters are considered as
                // matching in two cases
                // (a) current character of pattern is '?'
                // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?'
                         || str.charAt(i - 1)
                                == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];
 
                // If characters don't match
                else
                    lookup[i][j] = false;
            }
        }
        System.out.println("Printing after all check array--");
        ab.printArr(lookup, n, m);
		
        System.out.println("\n\n\n");
        System.out.println("Ans--"+lookup[n][m]);
		System.out.println("****** END ******");
	}
	
}

