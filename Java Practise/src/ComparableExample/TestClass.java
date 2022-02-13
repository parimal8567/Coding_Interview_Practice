package ComparableExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		Vehicle v1=new Vehicle();
		Vehicle v2=new Vehicle();
		Vehicle v3=new Vehicle();
		List<Vehicle> vehicleList=new ArrayList<Vehicle>();
		
		v1.setId(1001);
		v1.setName("Maruti");
		v1.setPrice(100000);
		
		v2.setId(4001);
		v2.setName("Toyota");
		v2.setPrice(200000);
		
		v3.setId(3001);
		v3.setName("Honda");
		v3.setPrice(200000);
		
		vehicleList.add(v1);
		vehicleList.add(v2);
		vehicleList.add(v3);
		
		Collections.sort(vehicleList,new VehicleSortByPriceAndId());
		System.out.println(vehicleList.toString());
		
	}
}
