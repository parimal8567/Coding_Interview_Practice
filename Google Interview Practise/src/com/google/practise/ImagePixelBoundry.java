package com.google.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.stream.Collectors;

/*
Q1: Given a binary image, with pixel value equal to 0 (background) or 1 (foreground), 
find the boundary pixels,

A pixel is a boundary pixel if
It's foreground (pixel value = 1),
It has at least 1 background pixel among its 4 neighbors (up, bottom, left, right). 
[Note: Pixels on the image border do not have 4 neighbors, see below]

Example

0  0  0  0  0  0
0  1  1  1  0  0
0  1  1  1  1  0
0  1  1  1  0  0
0  0  0  1  0  0

Boundary pixels (marked as b)

0  0  0  0  0  0
0  b  b  b  0  0
0  b  1  1  b  0
0  b  b  b  0  0
0  0  0  b  0  0

02: Compute the distance transform (DT) of this binary image.
For each pixel, the DT is equal to the distance to its nearest boundary pixel
Here the distance is defined as (rowl-row2| + |col1-col2| (Manhattan distance)
Candidates may call the function in 01.

0  0  0  0  0  0          0  0  0  0  0  0            2  1  1  1  2  3 
0  1  1  1  0  0          0  b  b  b  0  0            1  0  0  0  1  2
0  1  1  1  1  0          0  b  1  1  b  0            1  0  1  1  0  1
0  1  1  1  0  0          0  b  b  b  0  0            1  0  0  0  1  2
0  0  0  1  0  0          0  0  0  b  0  0            2  1  1  0  1  2
   Image                       Boundaries			Distance Transform ( Output )
*/

public class ImagePixelBoundry {

	public static void main(String[] args) {
		
		List<List<String>> matrix=new ArrayList<>();
		
		List<String> row1=Arrays.asList("0","0","0","0","0","0");
		List<String> row2=Arrays.asList("0","1","1","1","0","0");
		List<String> row3=Arrays.asList("0","1","1","1","1","0");
		List<String> row4=Arrays.asList("0","1","1","1","0","0");
		List<String> row5=Arrays.asList("0","0","0","1","0","0");

		matrix.add(row1);
		matrix.add(row2);
		matrix.add(row3);
		matrix.add(row4);
		matrix.add(row5);
		
		System.out.println("  -:  Question 1 :-");
		printMatrix(matrix);
		
		System.out.println("  -:  Answer 1 :-");
		List<List<String>> resultList=findBoundryPixel(matrix);
		printMatrix(resultList);
		
		System.out.println("  -:  Answer 2 :-");
		List<List<String>> distanceTransform=findDT(resultList);
		printMatrix(distanceTransform);
		
		
	}
	
	private static List<List<String>> findDT(List<List<String>> resultList) {
		
		String[][] data=convertToArr(resultList);
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[0].length;j++) {
				if(data[i][j].equals("0")) {
				String cell=findNearbyBoundryCell(i,j,data);
				int row=getRow(cell);
				int col=getCol(cell);
				data[i][j]=String.valueOf(Math.abs(row-i)+Math.abs(col-j));
				}
				
			}
		}
		
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[0].length;j++) {
				if(data[i][j].equals("b")) {
				data[i][j]="0";
				}
				
			}
		}
		
		return coonvertToList(data);
		
		
	}

	private static String findNearbyBoundryCell(int i, int j, String[][] data) {
		Queue<String> queue=new LinkedList<>();
		queue.add(String.valueOf(i)+String.valueOf(j));
		while(!queue.isEmpty()) {
			String cell=queue.poll();
			int row=getRow(cell);
			int col=getCol(cell);
			if(data[row][col].equals("b")) {
				return String.valueOf(row)+String.valueOf(col);
			}
			else {
				List<String> neighbours=getNeighbourCells(data,row,col);
				queue.addAll(neighbours);
			}
			
		}
		return null;
		
	}

	private static List<String> getNeighbourCells(String[][] data, int row, int col) {
		List<String> neighbours=new ArrayList<>();
		
			if(row+1<data.length)
				neighbours.add(String.valueOf(row+1)+String.valueOf(col));
			if(row-1>0 )
				neighbours.add(String.valueOf(row-1)+String.valueOf(col));
			if(col+1<data[0].length )
				neighbours.add(String.valueOf(row)+String.valueOf(col+1));
			if(col-1>0 )
				neighbours.add(String.valueOf(row)+String.valueOf(col-1));
		
			
		return neighbours;
	}

	private static int getRow(String cell) {
		return Integer.parseInt(String.valueOf(cell.charAt(0)));
	}
	
	private static int getCol(String cell) {
	return Integer.parseInt(String.valueOf(cell.charAt(1)));
	}
	
	private static List<List<String>> coonvertToList(String[][] dataSet){
		return Arrays.stream(dataSet)
                .map(Arrays::asList)
                .collect(Collectors.toList());
	}
	
	private static String[][] convertToArr(List<List<String>> data){
		String[][] pixelArr=data.stream()
				.map(l->l.stream().toArray(String[]::new))
				.toArray(String[][]::new);
		
		return pixelArr;
	}

	private static List<List<String>> findBoundryPixel(List<List<String>> matrix) {
		
		String[][] pixelArr=matrix.stream()
				.map(l->l.stream().toArray(String[]::new))
				.toArray(String[][]::new);
		
		for(int i=0;i<pixelArr.length;i++) {
			for(int j=0;j<pixelArr[0].length;j++) {
				
				// if all neighboring nodes are not 1 ( forground ) then replace it with b
				if(pixelArr[i][j].equals("1")) {
					
					if(isBoundry(i,j,pixelArr)) 
						pixelArr[i][j]="b";
				}
			}
		}
		
		return coonvertToList(pixelArr);
		
		
	}
	
	
	

	private static boolean isBoundry(int i, int j, String[][] pixelArr) {
		
		if(i+1 < pixelArr.length)		
			if(pixelArr[i+1][j].equals("0") )
				return true;
		
		if(i-1 >= 0 )	
			if(pixelArr[i-1][j].equals("0") )
			return true;
		
		if(j-1 >= 0)
			if(pixelArr[i][j-1].equals("0"))
			return true;
		
		
		if(j+1 < pixelArr[0].length)
			if(pixelArr[i][j+1].equals("0"))
			return true;
			
		return false;
	}

	private static void printMatrix(List<List<String>> matrix) {
		
		for(List<String> rows:matrix) {
			for(String row:rows) {
				System.out.print(row);
			}
			System.out.print("\n");
		}
	}
}
