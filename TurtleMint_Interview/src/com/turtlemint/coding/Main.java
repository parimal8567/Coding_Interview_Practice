package com.turtlemint.coding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
/********** Station ***********/
		
		
		TrainStation ts=new TrainStation();
		ts.setId(1);
		ts.setStationName("B");
		ts.setNumberOfPlatforms(4);
		
		TrainStation ts1=new TrainStation();
		ts1.setId(2);
		ts1.setStationName("C");
		ts1.setNumberOfPlatforms(4);
		
		TrainStation ts2=new TrainStation();
		ts2.setId(3);
		ts2.setStationName("D");
		ts2.setNumberOfPlatforms(4);
		
		TrainStation ts3=new TrainStation();
		ts3.setId(4);
		ts3.setStationName("G");
		ts3.setNumberOfPlatforms(4);
		
		TrainStation ts4=new TrainStation();
		ts3.setId(5);
		ts3.setStationName("Y");
		ts3.setNumberOfPlatforms(4);
		
		
		List<TrainStation> trainStations1=new ArrayList<>();
		trainStations1.add(ts);
		trainStations1.add(ts1);
		trainStations1.add(ts2);
		
		List<TrainStation> trainStations2=new ArrayList<>();
		trainStations1.add(ts4);
		
		
		
		
		Train train1=createTrain(1,"Train 1",trainStations1,"A","E");
		Train train2=createTrain(2,"Train 2",trainStations2,"X","Z");
		
		List<Train> existingTrains=new ArrayList<>();
		existingTrains.add(train1);
		existingTrains.add(train2);
		
		List<Train> trains= searchTrains("C","B",new Date(),existingTrains);
		for(Train tr:trains)
			System.out.println(tr.getName());
		
		
	}
	
	
	
	public static List<Train> searchTrains(String start, String end, Date startDate, List<Train> trains){
		List<Train> result=new ArrayList<>();
		
		for(Train train:trains) {
			List<TrainItirnery> itineries=train.getIntineries();
			
			
			if(null!=itineries) {
				for(TrainItirnery ti:itineries) {
					if(start.equals(ti.getStartDestination()) || checkStationContains(ti.getStations(),start)) {
						
						if(end.equals(end) || checkStationContains(ti.getStations(),start,end)) {
							result.add(train);	
						}
					}
				}
			}
		}
		
		
		if(result.isEmpty())
			System.out.println("No trains available");
		
		return result;
	}
	
	
	private static boolean checkStationContains(List<TrainStation> stations, String end) {
		for(TrainStation ts:stations) {
			if(ts.getStationName().equals(end)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean checkStationContains(List<TrainStation> stations, String start, String end) {
		for(TrainStation ts:stations) {
			if(ts.getStationName().equals(end)) {
				return true;
			}
		}
		return false;
	}



	private static Train createTrain(int id,String trainName,List<TrainStation> trainStations, String startDestination, String endDestination) {
		Train train1=new Train();
		train1.setCapacity(1000);
		train1.setId(id);
		train1.setName(trainName);
		
		TrainItirnery it1=new TrainItirnery();
		it1.setId(1);
		it1.setStartDestination(startDestination);
		it1.setEndDestination(endDestination);
		
		it1.setStations(trainStations);
		it1.setStartDate(new Date());
		it1.setStartDate(new Date());
		
		List<TrainItirnery> itineries=new ArrayList<>();
		itineries.add(it1);
		train1.setIntineries(itineries);
		
		return train1;
	}
	

}
