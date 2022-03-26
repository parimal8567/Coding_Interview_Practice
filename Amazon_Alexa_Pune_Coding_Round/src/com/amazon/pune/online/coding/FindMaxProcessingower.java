package com.amazon.pune.online.coding;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/*
 * Incomplete due to time restriction
 */

public class FindMaxProcessingower {

	public String solution(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {
		List<Integer> a=new ArrayList<>();
		a.add(1);
		a.add(-1);
		a.add(1);
		a.add(-1);
		
		System.out.println(2%2);
		System.out.println(2/2);
		System.out.println(a.size());
		
		
		
		
		
		
		for(int k=2;k<processingPower.size();k++){
            List<Integer> subPower=processingPower.subList(0, k);
            List<Integer> s=bootingPower.subList(0, k);
            
            Optional<Integer> max=s.stream().max(Comparator.naturalOrder())
            int result=max.get()+(subPower.stream().mapToInt(Integer::intValue).sum() * k);
            if(result>powerMax){
                break;
            }    
        }
		
		
		return "";
	}
	
	public static void main(String[] args) {
		FindMaxProcessingower fc=new FindMaxProcessingower();
		String res=fc.solution();
	}
}
