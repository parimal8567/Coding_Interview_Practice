package Collections;

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
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + (int) (price ^ (price >>> 32));
//		return result;
		
		int hashcode=1;
		
		hashcode=hashcode+id;
		for(char c:name.toCharArray()) {
			hashcode=hashcode+(int)c;
		}
		hashcode=hashcode+(int)price/7;
		return hashcode;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
}
