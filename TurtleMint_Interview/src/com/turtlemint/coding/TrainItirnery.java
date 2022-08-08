package com.turtlemint.coding;

import java.util.Date;
import java.util.List;

public class TrainItirnery {
	
	int id;
	String itineryName;
	String startDestination;
	List<TrainStation> stations;
	String endDestination;
	Date startDate;
	Date endDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItineryName() {
		return itineryName;
	}
	public void setItineryName(String itineryName) {
		this.itineryName = itineryName;
	}
	public String getStartDestination() {
		return startDestination;
	}
	public void setStartDestination(String startDestination) {
		this.startDestination = startDestination;
	}
	public List<TrainStation> getStations() {
		return stations;
	}
	public void setStations(List<TrainStation> stations) {
		this.stations = stations;
	}
	public String getEndDestination() {
		return endDestination;
	}
	public void setEndDestination(String endDestination) {
		this.endDestination = endDestination;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
