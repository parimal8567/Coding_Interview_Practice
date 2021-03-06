package TwoDArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NoOfIslands {

	public int numIslands(char[][] grid) {
		int numOfIsland = 0;
		System.out.println("Rows="+grid.length);
		System.out.println("Cols="+grid[0].length);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					grid[i][j]='0';
					numOfIsland++;
					destroyIsland(formCell(i,j),grid);
				}
			}
		}
		return numOfIsland;
	}
	
	public void destroyIsland(String cell, char[][] grid) {
		
		Stack<String> stack = new Stack<>();
		stack.add(cell);
		while(!stack.empty()) {
			String startCell = stack.pop();
			List<String> neighbours = getNeighbours(getRow(startCell),getCol(startCell), grid);
			stack.addAll(neighbours);
			
		}
	}

	public List<String> getNeighbours(int i, int j, char[][] grid) {
		List<String> neighbours = new ArrayList<>();
		if (i - 1 >= 0 )
			if(grid[i-1][j]=='1') {
				neighbours.add(formCell(i - 1, j));
				grid[i-1][j]='0';
			}
		if (i + 1 < grid.length)
			if(grid[i+1][j]=='1') {
				neighbours.add(formCell(i + 1, j));
				grid[i+1][j]='0';
			}
		if (j - 1 >= 0)
			if(grid[i][j-1]=='1') {
				neighbours.add(formCell(i, j - 1));
				grid[i][j-1]='0';
			}
		if (j + 1 < grid[0].length)
			if(grid[i][j+1]=='1') {
				neighbours.add(formCell(i, j + 1));
				grid[i][j+1]='0';
			}
		return neighbours;
	}

	public String formCell(int i, int j) {
		return String.valueOf(i) + ',' +String.valueOf(j);
	}

	public int getRow(String cell) {
		return Integer.parseInt(String.valueOf(cell.split(",")[0]));
	}

	public int getCol(String cell) {
		return Integer.parseInt(String.valueOf(cell.split(",")[1]));
	}

	public static void main(String[] args) {
		NoOfIslands ni=new NoOfIslands();
//		char[][] data=new char[][] {{'1','1','1','1','1','0'},
//									{'1','1','1','0','1','0'},
//									{'1','1','1','0','0','0'},
//									{'0','0','0','0','0','0'},
////									{'0','0','0','0','0','0'}
//		};
		
//		char[][] data=new char[][] {{'1','1','0','0','0'},
//									{'1','1','0','0','0'},
//									{'0','0','1','0','0'},
//									{'0','0','0','1','1'}
//		};
		
//		char[][] data=new char[][] {{'1','1','1'},
//									{'0','1','0'},
//									{'1','1','1'}
//		};
		
//		
		char[][] data=new char[][] {{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','1','1','1',
		  '1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','0','0','1','1','1','1','1','1','1','1','1','1',
		  '1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
		
//		  
//		  char[][] data=new char[][] {{'1','1','1','1','0'},
//			  						  {'1','1','0','1','0'},
//			  						  {'1','1','0','0','0'},
//			  						  {'0','0','0','0','0'}
//			  						  };
//			  						  
//		char[][] data=new char[][]	  {{'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',
//			'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',
//			'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',
//			'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',
//			'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',
//			'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',
//			'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',
//			'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
//			{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',
//			'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',
//			'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',
//			'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',
//			'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',
//			'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',
//			'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',
//			'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0'}};
		  
		System.out.println(ni.numIslands(data));

	}

}
