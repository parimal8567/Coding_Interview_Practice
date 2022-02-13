package Inheritance;

public class ChildClass extends BaseClass{

	int b=10;
	@Override
	public void show() {
		System.out.println("This is child");
	}
	
	public static void main(String[] args) {
		ChildClass c=new ChildClass();
		c.show();
	}
}
