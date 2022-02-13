package StaticBlock;

public class First {
	{
		System.out.println("First block");
	}
	static
	{
		System.out.println("First static block");
	}
}
