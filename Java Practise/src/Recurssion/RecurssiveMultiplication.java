package Recurssion;

public class RecurssiveMultiplication {

	public int recursiveMultiply(int number){
		
		int result=1;
		if(number/10>=1)
		{
			int reminder=number%10;
			int quotient=number/10;
			 result=result*reminder;
			return result * recursiveMultiply(quotient);
		}
		else {
			return number;
		}
		
	}
	
	public static void main(String[] args) {
		RecurssiveMultiplication r=new RecurssiveMultiplication();
		System.out.println(r.recursiveMultiply(1234));
	}
}
