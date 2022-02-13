package Collections;

public class LinkedList extends Node{

	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		LinkedList l2=new LinkedList();
		LinkedList l3=new LinkedList();
		LinkedList l4=new LinkedList();
		LinkedList l5=new LinkedList();
		
		l1.value=1;
		l1.node=l2;
		
		l2.value=2;
		l2.node=l3;
		
		l3.value=3;
		l3.node=l4;
		
		l4.value=4;
		l4.node=l5;
		
		l5.value=5;
		l5.node=null;
		
		System.out.println(l1);
		

		
	}
}
