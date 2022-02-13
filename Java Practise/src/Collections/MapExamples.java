package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {

	public static void main(String[] args) {
		Map<Vehicle,Vehicle> map=new HashMap<Vehicle,Vehicle>();
		
		Vehicle v1=new Vehicle();
		Vehicle v2=new Vehicle();
		Vehicle v3=new Vehicle();
		v1.setId(1);
		v2.setId(2);
		v3.setId(1);
		
		v1.setName("ABC");
		v2.setName("EFG");
		v3.setName("ABC");
		
		v1.setPrice(1234);
		v2.setPrice(5678);
		v3.setPrice(1234);
		
		map.put(v1, v1);
		map.put(v2, v2);
		map.put(v3, v3);
		System.out.println(map.size());
	}
	
}
