package Overriding;

public class Derived extends Base{

	double height=0.5;
	Derived(){
		doSomething();
	}
	
	public void doSomething() {
		System.out.println("height"+" "+height); 
	}
}
