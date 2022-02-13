package ComparableExample;

public class Vehicle {

	int id;
	String name;
	long price;
	
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	
	
	
}
