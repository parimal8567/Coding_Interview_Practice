package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
public static void main(String[] args) {
	
	
	
	int numProducts=5; 
    List<String> repository=new ArrayList<>();
    repository.add("code");
    repository.add("codePhone");
    repository.add("coddle");
    repository.add("coddles");
    repository.add("codes");
    
    String customerQuery="coddle";
    
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
        
        resultSet.subList(0, 3);
        
     }
      i++;
    Collections.sort(resultSet);  
    finalResults.add(resultSet);
     
    }
    System.out.println(finalResults);
}
}
