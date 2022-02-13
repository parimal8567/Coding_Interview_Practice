package Polymorphisam;

public class PolyChild extends PolyTest{
public static void main(String[] args) {
	String str="parimal";
	String str1=new String("parimal");
	
	
	System.out.println("Str has hascode:"+str.hashCode());
	System.out.println("Str has hascode:"+str1.hashCode());
}
}
