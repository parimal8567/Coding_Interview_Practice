package ComparableExample;

import java.util.Comparator;

public class VehicleSortByPriceAndId implements Comparator<Vehicle>{


	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		int flag=(int) (o1.price-o2.price);
		if(flag==0)
		{
			flag=o1.getId()-o2.getId();
		}
		return flag;
	}



}
