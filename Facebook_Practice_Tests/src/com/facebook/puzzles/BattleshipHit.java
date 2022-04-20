package com.facebook.puzzles;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BattleshipHit {
	
	public double getHitProbability(int R, int C, int[][] G) {
	    
	    double battleShipsCount=0;
	    for(int i=0;i<R;i++){
	      for(int j=0;j<C;j++){
	        if(G[i][j]==1)
	          battleShipsCount++;
	      }
	    }
	    System.out.println("Battleship="+battleShipsCount);
	    System.out.println("Total cells="+R*C);
	    double result=battleShipsCount/(R*C);
	    return result;
	  }
	
	public static void main(String[] args) {
		BattleshipHit bh=new BattleshipHit();
		int R=2;
		int C=3;
		int[][] G= {{0,0,1},{1,0,1}};
		
		double answer=bh.getHitProbability(R, C, G);
		System.out.println("Answer="+answer);
		
	}

}
