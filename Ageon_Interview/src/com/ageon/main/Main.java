package com.ageon.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ageon.domain.Customer;
import com.ageon.domain.Employee;
import com.ageon.domain.Person;

public class Main {

	public static void main(String[] args) {
		
		List<Customer> customerList=new ArrayList<>();
		List<Employee> employeeList=new ArrayList<>();
		
	
		Person p1=new Person("ABC",10,"Add1");	
		Person p2=new Person("PQR",11,"Add2");
		Person p3=new Person("ABC",10,"Add3");
		Person p4=new Person("PQRS",13,"Add4");
	
		
		customerList.add(new Customer(p1));
		customerList.add(new Customer(p2));
		
		employeeList.add(new Employee(p3));
		employeeList.add(new Employee(p4));
		
		for(Customer cust:customerList) {
			String name=cust.getCustomer().getName();
			int age=cust.getCustomer().getAge();
			for(Employee emp:employeeList) {
				if(emp.getEmployee().getName().equals(name) && emp.getEmployee().getAge()==age) {
					Person p=cust.getCustomer();
					p.setAddress(emp.getEmployee().getAddress());
					
				}
			}
		}
		
		
		System.out.println(customerList);
		

//		customerList.stream().fin
		
		


		
		
		
		
	
		
		
	}
}
