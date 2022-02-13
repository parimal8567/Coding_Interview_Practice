package stacks.swap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SwapElementsInLinkedList {

	public static class Node{
		public Node(char c) {
			this.val=c;
			this.next=null;
		}
		char val;
		Node next;
	}
	
	public Node swapV_C(Node head){
		
		if(head==null) {
			return null;
		}
		
		// to store node having constants characters.
		Stack<Node> stack=new Stack<Node>();
		Queue<Node> queue=new LinkedList<Node>();
		Node curr=head;
		
		
		Node prevNode=curr;
		while(curr!=null) {
			if(!isVowel(curr.val)) {
				queue.add(curr);
				prevNode.next=curr.next;
				curr=prevNode.next;
			}else {
			
				prevNode=curr;
				curr=curr.next;
			}
			
			
		}

		if(queue.peek()!=null) {
			prevNode.next=queue.peek();
		}
		while(!queue.isEmpty()) {
			Node n=queue.poll();
			if(null!=n) {
				n.next=queue.peek();
			}
		}
		
		
		return head;
	}
	
	
	private boolean isVowel(char x) {
		return (x == 'a' || x == 'e' || x == 'i' ||  
	            x == 'o' || x == 'u');
	}


	public static void main(String[] args) {
		
		SwapElementsInLinkedList st=new SwapElementsInLinkedList();
		Node head=new Node('a');
		head.next=new Node('b');
		head.next.next=new Node('c');
		head.next.next.next=new Node('d');
		head.next.next.next.next=new Node('e');
		head.next.next.next.next.next=new Node('i');
		head.next.next.next.next.next.next=new Node('g');
			
		
		
		Node headNode= st.swapV_C(head);
		while(headNode!=null) {
			System.out.println(headNode.val);
			headNode=headNode.next;
		}
		
	}
}
