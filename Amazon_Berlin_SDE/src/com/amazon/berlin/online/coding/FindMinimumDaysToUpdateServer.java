package com.amazon.berlin.online.coding;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given an n*m matrix with 1,0 values
 * 1- Updated server
 * 0- Needs to be updated
 * Find the maximum number of days to update all the servers.
 * 
 */
public class FindMinimumDaysToUpdateServer {

	
	public int minimumDays(List<List<Integer>> grid, int rows, int columns) {
		
		
		int[][] gridArr=new int[rows][columns];
		int k=0;
        while(k<rows){
           for(List<Integer> row:grid){
        	   int j=0; 
            for(Integer col:row){
            	
                gridArr[k][j]=col;
                j++;
            }
            k++;
        } 
        }
	
	
        int daysCount=0;
        int outOfDateNoes=rows*columns;
        
        while(outOfDateNoes>0){
            
            outOfDateNoes=0;
            int[][] duplicateGridArr=new int[rows][columns];
            
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(gridArr[i][j]==1){
                	duplicateGridArr[i][j]=1;
                    //check down
                    if(i!=rows-1){
                        if(gridArr[i+1][j]==0){
                            
                        	duplicateGridArr[i+1][j]=1;
                            
                        }
                    }
                    //check up 
                    if(i!=0){
                    
                        if(gridArr[i-1][j]==0){
                        
                        	duplicateGridArr[i-1][j]=1;
                        
                    }
                    }
                    
                    
                    // check right
                    if(j!=columns-1){
                    if(gridArr[i][j+1]==0){
                        
                    	duplicateGridArr[i][j+1]=1;
                        
                    }
                    }
                    
                    //check left
                    if(j!=0){
                    if(gridArr[i][j-1]==0){
                       
                    	duplicateGridArr[i][j-1]=1;
                       
                    }
                    }
                    
                    
                }else {
                	outOfDateNoes++;
                }
            }
        }
        daysCount++;
        gridArr=duplicateGridArr;
        }
        return daysCount;
	}
	public static void main(String[] args) {
	
		int rows=5;
		int columns=5;
		List<List<Integer>> grid=new ArrayList<List<Integer>>();
		List<Integer> a=new ArrayList<>();
		a.add(1);
		a.add(0);
		a.add(0);
		a.add(0);
		a.add(0);
		
		List<Integer> b=new ArrayList<>();
		b.add(0);
		b.add(1);
		b.add(0);
		b.add(0);
		b.add(0);
		
		List<Integer> c=new ArrayList<>();
		c.add(0);
		c.add(0);
		c.add(1);
		c.add(0);
		c.add(0);
		
		List<Integer> d=new ArrayList<>();
		d.add(0);
		d.add(0);
		d.add(0);
		d.add(1);
		d.add(0);
		
		List<Integer> e=new ArrayList<>();
		e.add(0);
		e.add(0);
		e.add(0);
		e.add(0);
		e.add(1);
		
		grid.add(a);
		grid.add(b);
		grid.add(c);
		grid.add(d);
		grid.add(e);
		
		
		FindMinimumDaysToUpdateServer t1=new FindMinimumDaysToUpdateServer();
		int result=t1.minimumDays(grid, rows, columns);
				
		System.out.println(result-1);
		
	
	
	}
}
