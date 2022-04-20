package com.facebook.puzzles.level1;


import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kaitenzushi {
	  
	  public int getMaximumEatenDishCount(int N, int[] D, int K) {
	    int maxEatenDishCount=1;
	    Queue<Integer> qu=new LinkedList<>();
	    PriorityQueue<Integer> pq=new PriorityQueue<>();
	    qu.add(D[0]);
	    
	    maxEatenDishCount=queueResize(qu,1,D[1],maxEatenDishCount,K, D);
	    
	    return maxEatenDishCount;
	  }
	  
	  public int queueResize(Queue<Integer> qu,int i, int number, int maxEatenDishCount, int K,int[] D) {
		  if(!qu.contains(number)) {
		    	maxEatenDishCount++;
		    	if(qu.size()==K)
		    		qu.remove();
		    	qu.add(number);
		    }
		  
		  if(i==D.length-1)
			  return maxEatenDishCount;

			return queueResize(qu,i+1,D[i+1],maxEatenDishCount,K,D);
		  
	  }
	  
	  public static void main(String[] args) {
	
		  Kaitenzushi k=new Kaitenzushi();
		  Date date=new Date();
		  long start=date.getTime();
		  int N=6;
		  int K=1;
		  int[] D= {1,2,3,3,2,1};
//		  int[] D= {1,2,1,2,1,2,1};
		  int count=k.getMaximumEatenDishCount(N, D, K);
		  long end=date.getTime();
		  
		  System.out.println("Time Taken="+(end-start));
		  
		  System.out.println("Answer="+count);
	}

}
