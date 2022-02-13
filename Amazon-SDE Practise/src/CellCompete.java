import java.util.ArrayList;
import java.util.List;

public class CellCompete {
public static void main(String[] args) {
	

    // WRITE YOUR CODE HERE
    
	int[] states= {1,1,1,0,1,1,1,1};
	int x=1;
	while( x<=2) {
		int result[]=new int[states.length];
	    
        
	    for(int i=0;i<states.length;i++){
	        if(i==0 )
	        {
	            if(states[i+1]==0){
	                result[0]=0;
	            }else{
	                result[0]=1;
	            }
	            continue;
	        }
	        
	        if(i==states.length-1){
	            if(states[i-1]==0){
	                result[i]=0;
	            }else{
	                result[i]=1;
	            }
	            continue;
	        }else {
	        
	        if(states[i-1]==states[i+1] ){
	            result[i]=0;
	        }else{
	            result[i]=1;
	        }
	        }
	       
	    }
	    states=result;
	    x++;
	}
    
    
    List<Integer> resultList=new ArrayList<>();
    for(int i:states){
        resultList.add(i);
    }
    System.out.println(resultList);
    }
	
}

