package com.turtlemint.coding;

import java.util.List;

public class Train {
	
	int id;
	String name;
	List<TrainItirnery> intineries;
	int capacity;
	Schedule schedule;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TrainItirnery> getIntineries() {
		return intineries;
	}
	public void setIntineries(List<TrainItirnery> intineries) {
		this.intineries = intineries;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	

}
