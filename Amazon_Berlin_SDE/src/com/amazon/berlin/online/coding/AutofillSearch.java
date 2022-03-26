package com.amazon.berlin.online.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Return the top 3 results in sorted order from repository list for 
 * each word customer adds from the given string.
 * Example : coddle
 * 
 * [
 * [coddle, coddles, code, codePhone, codes],
 * [coddle, coddles, code, codePhone, codes],
 * [coddle, coddles],
 * [coddle, coddles],
 * [coddle, coddles]
 * ]
 * 
 *
 */
public class AutofillSearch {
	
	public List<List<String>> solution(List<String> repository, String customerQuery) {
		 
		List<List<String>> finalResults=new ArrayList<List<String>>();    
	    int i=2;
	    //System.out.println(customerQuery.length());
	    while(i<=customerQuery.length())
	    {
	    //	System.out.println(i);
	      String subString=customerQuery.substring(0,i);
	      
	      List<String> resultSet=new ArrayList<>();
	      for(String productName:repository){
	        if(productName.startsWith(subString)){
	         resultSet.add(productName);   
	        }
	        
	        
	        
	     }
	      if(resultSet.size()>3)
	    	  resultSet.subList(0, 3);
	    	  
	      i++;
	    Collections.sort(resultSet);  
	    finalResults.add(resultSet);
	     
	    }
	    return finalResults;
	}
	
public static void main(String[] args) {
	
    List<String> repository=new ArrayList<>();
    repository.add("code");
    repository.add("codePhone");
    repository.add("coddle");
    repository.add("coddles");
    repository.add("codes");
    
    String customerQuery="coddle";
    AutofillSearch as=new AutofillSearch();
    List<List<String>> finalResults=as.solution(repository,customerQuery);
   
    System.out.println(finalResults);
}
}
