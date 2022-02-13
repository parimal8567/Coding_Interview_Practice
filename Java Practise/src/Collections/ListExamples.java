package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ListExamples {

	
	
	public static void main(String[] args) {
		List<String> strList=new ArrayList<>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		
		System.out.println(strList.get(1));
		
		List<String> strlinkList=new LinkedList<>();
		strlinkList.add("p");
		strlinkList.add("q");
		strlinkList.add("r");
		strlinkList.add("s");
		System.out.println(strlinkList.get(1));
		
		Iterator itr=strlinkList.iterator();
		
		
		
		
		
	}
}
