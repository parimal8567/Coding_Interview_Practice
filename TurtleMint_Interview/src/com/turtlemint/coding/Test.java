package com.turtlemint.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		List<Employee> abc=new ArrayList<>();
		
		List<Employee> males=new ArrayList<>();
		List<Employee> females=new ArrayList<>();
		
		abc.stream().forEach(e->{
			if(e.gender.equals("M"))
				males.add(e);
			else
				females.add(e);
		});
		
		
		
		List<Employee> pqr=abc.stream().filter(e->e.age>14).collect(Collectors.toList());
	}
}
