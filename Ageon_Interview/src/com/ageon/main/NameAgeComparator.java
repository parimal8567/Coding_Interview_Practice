package com.ageon.main;

import java.util.Comparator;

import com.ageon.domain.Person;

public class NameAgeComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Person cust=(Person)o1;
		Person employee=(Person)o2;
		
		if(cust.getName()==employee.getName()) {
			if(cust.getAge()==employee.getAge()) {
				cust.setAddress(employee.getAddress());
				return 0;
			}
		}
		return -1;
	}

}
