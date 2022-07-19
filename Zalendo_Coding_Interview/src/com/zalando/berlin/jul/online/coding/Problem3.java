package com.zalando.berlin.jul.online.coding;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
	
	public int solution(String[] E) {
        int row=10;
        int col=E.length;
        int[][] grid=new int[row][col];
        for(int i=0;i<E.length;i++){
            String days=E[i];
            for(int j=0;j<days.length();j++){
                char c=days.charAt(j);
                int rowT=Integer.parseInt(String.valueOf(c));
                grid[rowT][i]=1;
            }
        }
        String[] result=new String[10];
        for(int i=0;i<row;i++){
        	StringBuilder sb=new StringBuilder();
            for(int j=0;j<col;j++){
            	if(grid[i][j]==1)
            		sb.append(j);
            }
            result[i]=sb.toString();
        }
        
        printGrid(grid);
//        printResult(result);
        
        int max=0;
        for(int i=0;i<result.length;i++) {
        	if(max<result[i].length())
        		max=result[i].length();
        }
        
        Set<String> resultSet=new HashSet<>();
        
        if(max==col) {
        	return E.length;
        }else {
        	int maxEmp=0;
        	for(int i=0;i<result.length;i++) {
        		for(int j=0;j<result.length;j++) {
        			resultSet.add(result[i]+result[j]);
        			if(resultSet.size()>maxEmp)
        				maxEmp=resultSet.size();
        			
        			resultSet.clear();
        			
        		}
        		
        	}
        	

        	return maxEmp;
        }
        
        
        
    }
	
	private void printResult(int[] result) {
		System.out.println("***** Result *******");
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]);
		System.out.println("");
		
	}

	private void printGrid(int[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
				
		}
		
	}

	public static void main(String[] args) {
		String[] E= {"039","4","14","32","","34","7"};
		Problem3 pb3=new Problem3();
		int result=pb3.solution(E);
		System.out.println("Result:-  "+result);
		
	}

}
