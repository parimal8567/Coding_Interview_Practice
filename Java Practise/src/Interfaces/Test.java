package Interfaces;

public class Test implements First,Last{

	static String name="Name";
	@Override
	public String getLast() {
		// TODO Auto-generated method stub
		return Last.name2;
	}

	@Override
	public String getFirst() {
		// TODO Auto-generated method stub
		return First.name1;
	}
	String name()
	{
		return Test.name+Test.name2;
	}

}
