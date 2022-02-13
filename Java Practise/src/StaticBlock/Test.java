package StaticBlock;

public class Test extends Second {
	static
	{
		System.out.println("Last static block");
	}
public static void main(String[] args) {
	Test t=new Test();
	System.out.println("end..");
}
}
