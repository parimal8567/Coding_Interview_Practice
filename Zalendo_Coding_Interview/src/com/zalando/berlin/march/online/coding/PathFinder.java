package com.zalando.berlin.march.online.coding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class PathFinder {
	
	public boolean solution(String[][] B) {
		Map<String,Set<String>> cellMap=new HashMap<>();
		
		// Fill the map of n*m matrix layout
		fillCellMap(B, cellMap);
		
		// Filter Cells as per gaurd's position
		filterCellMap(cellMap, B);
		
		Stack<String> stack=new Stack<>();
		
		Set<String> startElements=cellMap.get("A");
		String start=startElements.iterator().next();
		int row=Integer.parseInt(String.valueOf(start.charAt(0)));
		int col=Integer.parseInt(String.valueOf(start.charAt(1)));
		
		System.out.print("Path Followed-->");
		stack.add(String.valueOf(row)+String.valueOf(col));
		int totalPop=0;
		while(!stack.empty()) {
			String element=stack.pop();
			System.out.print(element+",");
			totalPop++;
			// get neighbor element
			int rowNum=Integer.parseInt(String.valueOf(element.charAt(0)));
			int colNum=Integer.parseInt(String.valueOf(element.charAt(1)));
			if(null==cellMap.get("V")) {
				Set<String> visitedRow=new HashSet<>();
				visitedRow.add(element);
				cellMap.put("V", visitedRow);
			}else {
				Set<String> visitedRows=cellMap.get("V");
				visitedRows.add(element);
			}
			
			int exitRow=B.length-1;
			int exitcol=B[0][0].length()-1;
			String exitCell=formElement(exitRow, exitcol);
			if(formElement(rowNum, colNum).equals(exitCell)) {
				System.out.println("-->>Reached! Whoa!!");
				System.out.println("Total Steps="+(totalPop-1));
				return true;
			}

			// Travel neighboring cells
			travelNeighbourCells(B, cellMap, stack, rowNum, colNum);

		}
		return false;
	}

	private void filterCellMap(Map<String, Set<String>> cellMap,String[][] B) {
		Set<String> leftFacingGaurd=cellMap.get("<");
		if(null!=leftFacingGaurd)
			filterCells(leftFacingGaurd, cellMap,B, "<");
		
		Set<String> rightFacingGaurd=cellMap.get(">");
		if(null!=rightFacingGaurd)
			filterCells(rightFacingGaurd, cellMap,B, ">");
		
		Set<String> upFacingGaurd=cellMap.get("^");
		if(null!=upFacingGaurd)
			filterCells(upFacingGaurd, cellMap,B, "^");
		
		Set<String> downFacingGaurd=cellMap.get("ᐯ");
		if(null!=downFacingGaurd)
			filterCells(downFacingGaurd, cellMap,B, "ᐯ");
		
		
	}
	
	private void filterCells(Set<String> cells, Map<String, Set<String>> cellMap,String[][] B, String key) {
		for(String cell:cells) {
			
			int rowNum=Integer.parseInt(String.valueOf(cell.charAt(0)));
			int colNum=Integer.parseInt(String.valueOf(cell.charAt(1)));
			if(key.equals("<")) {
				for(int i=colNum-1;i>=0;i--) {
					if(null!=cellMap.get("X") && cellMap.get("X").contains(formElement(rowNum, i)))
						return;
					removeCellsAsGaurdIsFacing(cellMap, B, rowNum, i);
				}	
			}
			
			if(key.equals(">")) {
				for(int i=colNum+1;i<=B[0][0].length()-1;i++) {
					if(null!=cellMap.get("X") && cellMap.get("X").contains(formElement(rowNum, i)))
						return;
					removeCellsAsGaurdIsFacing(cellMap, B, rowNum, i);
				}	
			}
			
			if(key.equals("^")) {
				for(int i=rowNum-1;i>=0;i--) {
					if(null!=cellMap.get("X") && cellMap.get("X").contains(formElement(i, colNum)))
						return;
					removeCellsAsGaurdIsFacing(cellMap, B, i, colNum);
				}	
			}
			
			if(key.equals("ᐯ")) {
				for(int i=rowNum+1;i<B.length;i++) {
					if(null!=cellMap.get("X") && cellMap.get("X").contains(formElement(i, colNum)))
						return;
					removeCellsAsGaurdIsFacing(cellMap, B, i, colNum);
				}	
			}
			
		}
	}

	private void removeCellsAsGaurdIsFacing(Map<String, Set<String>> cellMap, String[][] B, int rowNum, int colNum) {
		if(isSafeCell(rowNum, colNum, B) && cellMap.get(".").contains(formElement(rowNum, colNum))) {
//			cellMap.get("V").add(formElement(rowNum, colNum));
			cellMap.get(".").remove(formElement(rowNum, colNum));
		}
	}

	private void fillCellMap(String[][] B, Map<String, Set<String>> cellMap) {
		for(int i=0;i<B.length;i++) {
			String[] str=B[i];
			for(int j=0;j<str.length;j++) {
				String row=str[j];
				for(int k=0;k<row.length();k++) {
					if(String.valueOf(row.charAt(k)).equals("A")) {
						Set<String> allowed= cellMap.get(".");
						allowed.add(String.valueOf(i)+String.valueOf(k));
						
					}
					
					if(cellMap.containsKey(String.valueOf(row.charAt(k)))) {
						Set<String> rows=cellMap.get(String.valueOf(row.charAt(k)));
						rows.add(String.valueOf(i)+String.valueOf(k));
					}else {
						Set<String> rowType=new HashSet<>();
						rowType.add(String.valueOf(i)+String.valueOf(k));
						cellMap.put(String.valueOf(row.charAt(k)),rowType);
					}
						
				}
				
			}
		}
	}

	private void travelNeighbourCells(String[][] B, Map<String, Set<String>> cellMap, Stack<String> stack, int rowNum,
			int colNum) {
		//1. row, col++ --> travel right
		if(isSafeCell( rowNum,  colNum+1, B) && !cellMap.get("V").contains(formElement(rowNum,colNum+1)) && cellMap.get(".").contains(formElement(rowNum,colNum+1)))
			stack.add(String.valueOf(rowNum)+String.valueOf(colNum+1));
		
		
		//2. row++, col --> travel down
		if(isSafeCell( rowNum+1,  colNum, B) && !cellMap.get("V").contains(formElement(rowNum+1,colNum))&& cellMap.get(".").contains(formElement(rowNum+1,colNum)))
			stack.add(String.valueOf(rowNum+1)+String.valueOf(colNum));
		
		//3. row-1, col --> travel up
		if(isSafeCell( rowNum-1,  colNum, B) && !cellMap.get("V").contains(formElement(rowNum-1,colNum)) &&cellMap.get(".").contains(formElement(rowNum-1,colNum)))
			stack.add(String.valueOf(rowNum-1)+String.valueOf(colNum));
		
		//4. row, col-1 --> travel left
		if(isSafeCell( rowNum,  colNum-1, B) &&!cellMap.get("V").contains(formElement(rowNum,colNum-1)) &&cellMap.get(".").contains(formElement(rowNum,colNum-1)))
			stack.add(String.valueOf(rowNum)+String.valueOf(colNum-1));
	}
	
	
	private boolean isSafeCell(int row, int col, String[][] B) {
		if(row>=0 && row < B.length && col >= 0 && col<B[0][0].length())
			return true;
		else
			return false;
		
	}
	
	private String formElement(int row, int col) {
		return String.valueOf(row)+String.valueOf(col);
	}

	public static void main(String[] args) {
		PathFinder ps=new PathFinder();
//		String[][] input= {{"..X<"},{"...ᐯ"},{"AX.."},{".X.."}};
//		String[][] input= {{"...<"},{"...^"},{"...<"},{".A.."}};
		String[][] input= {{"...."},{".><."},{".><."},{".AX."}};
		if(ps.solution(input)) {
			System.out.println();
			System.out.println("PATH EXIST :)");
		}
		else {
			System.out.println();
			System.out.println("PATH DOES NOT EXIST (:");
		}
	}

}
