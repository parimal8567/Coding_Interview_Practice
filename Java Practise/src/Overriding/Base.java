package Overriding;

public class Base {
	double widhth=0.9;
	Base(){
		doSomething();
	}
	
	public void doSomething() {
		System.out.println("Width"+" "+widhth); 
	}
}
