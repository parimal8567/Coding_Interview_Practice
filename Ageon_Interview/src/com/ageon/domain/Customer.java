package com.ageon.domain;

public class Customer {

	private Person customer;

	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	public Customer(Person customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Customer [customer=" + customer + "]";
	}
	
	
	
}
