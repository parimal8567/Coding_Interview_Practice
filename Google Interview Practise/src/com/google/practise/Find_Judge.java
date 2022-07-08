package com.google.practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Find_Judge {
	
	 public int findJudge(int n, int[][] trust) {
	        Map<Integer,Set<Integer>> judgeMap=new HashMap<>();
	        for(int i=0;i<trust.length ;i++){
	            int person=trust[i][0];
	            int judge=trust[i][1];
	            if(judgeMap.containsKey(judge)) {
	            	Set<Integer> persons=judgeMap.get(judge);
	            	persons.add(person);
	            }else {
	            	Set<Integer> newPerson=new HashSet<>();
	            	newPerson.add(person);
	            	judgeMap.put(judge,newPerson);	
	            }
	            
	        }
	        for(Entry<Integer, Set<Integer>> str:judgeMap.entrySet()) {
	        	if(str.getValue().size()==n-1)
	        		return str.getKey();
	        	else
	        		return -1;
	        }
	        return -1;
	        	
	    }
	public static void main(String[] args) {
		Find_Judge fj=new Find_Judge();
		int[][] arr=new int[][] {{1,3},{2,3},{3,1}};
		System.out.println(fj.findJudge(3, arr));
	}

}
