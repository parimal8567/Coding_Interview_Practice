package Overriding;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
//		System.out.println("Hello!!");
//		Base b=new Derived();
//		System.out.println("End...");
		
		List<Integer> arr=new ArrayList<>();
		arr.add(3);
		arr.add(7);
		arr.add(9);
		arr.add(4);
		arr.add(7);
		arr.add(1);
		arr.add(6);
		
		List<Integer> result=arr.stream().filter(i->
			i%2!=0).limit(2).collect(Collectors.toList());
		
		System.out.println(result.toString());
	}
}
