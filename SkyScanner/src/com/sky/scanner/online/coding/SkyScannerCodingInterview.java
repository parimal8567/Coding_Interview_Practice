package com.sky.scanner.online.coding;

import java.util.HashSet;
import java.util.Set;

public class SkyScannerCodingInterview {

	public String[] solution(String[][] flights, String origin, double budget) {
        Set<String> results=new HashSet<>();
        int k=0;
		for(int i=0;i<flights.length;i++){
                 if(flights[i][0]==origin && Double.parseDouble(flights[i][2])<budget){
                	 results.add(flights[i][1]);
                     k++;
                 }// if closes
        }// outer for closes
   
		return results.stream().toArray(String[]::new);
	}
	
	public static void main(String[] args) {
		SkyScannerCodingInterview ssci=new SkyScannerCodingInterview();
		String[][] flights= {{"ABC","MNQ","112"},{"ABC","PQR","200"}};
		String origin="ABC";
		double budget=123.46;
		
		String[] result=ssci.solution(flights,origin,budget);
		for(String temp:result)
			System.out.println(temp);
	}
}
