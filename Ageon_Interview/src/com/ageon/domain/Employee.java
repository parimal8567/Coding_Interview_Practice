package com.ageon.domain;

public class Employee {

	private Person employee;

	public Person getEmployee() {
		return employee;
	}

	public void setEmployee(Person employee) {
		this.employee = employee;
	}

	public Employee(Person employee) {
		super();
		this.employee = employee;
	}
	
	
}
