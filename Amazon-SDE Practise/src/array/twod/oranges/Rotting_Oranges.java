package array.twod.oranges;

public class Rotting_Oranges {

	public int orangesRotting(int[][] grid) {
		
		int[][] duplicateGrid=new int[grid.length][3];
		
		int emptyNodes=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]==0) {
					emptyNodes++;
				}
				
			}
		}
		
		int nonRottenOranges=100;
		int minutesPassed=0;
		boolean noEffectFlag=true;
		while(nonRottenOranges-1>emptyNodes) {
			noEffectFlag=true;
			nonRottenOranges=0;
			
			for(int i=0;i<grid.length;i++) {
				for(int j=0;j<grid[i].length;j++) {
				
					if(grid[i][j]==2) {
						duplicateGrid[i][j]=2;
						//rot the left
						if(j!=0) {
						
							if(grid[i][j-1]==1) {
								duplicateGrid[i][j-1]=2;
								noEffectFlag=false;
							}
						}
						
						//rot the right
						if(j!=grid[i].length-1) {
							
							if(grid[i][j+1]==1) {
								duplicateGrid[i][j+1]=2;
								noEffectFlag=false;
							}
						}
						
						//rot the up
						if(i!=0) {
							if(grid[i-1][j]==1) {
								duplicateGrid[i-1][j]=2;
								noEffectFlag=false;
							}
						}
						
						//rot the down
						if(i!=grid.length-1) {
							if(grid[i+1][j]==1) {
								duplicateGrid[i+1][j]=2;
								noEffectFlag=false;
							}
						}
						
					}else {
						nonRottenOranges++;
//						duplicateGrid[i][j]=grid[i][j];
					}
				}
			}
			if(noEffectFlag) {
				System.out.println("Breaking due to no effect, should return -1");
				return -1;
			}
			minutesPassed++;
			for(int i=0;i<grid.length;i++) {
				for(int j=0;j<grid[i].length;j++) {
					if(duplicateGrid[i][j]==2) {
						grid[i][j]=duplicateGrid[i][j];	
					}
					
				}
			}
		}
		return minutesPassed;
        
    }

	public static void main(String[] args) {
	
		Rotting_Oranges rt=new Rotting_Oranges();
//		int[][] grid= {{2,1,1},{1,1,0},{0,1,1}};
//		int[][] grid= {{2,1,1},{0,1,1},{1,0,1}};
		int[][] grid= {{0,2}};
		
		int result=rt.orangesRotting(grid);
				System.out.println(result);
	}
}
