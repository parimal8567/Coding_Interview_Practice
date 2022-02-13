package binary.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class PostOrder {

	public static class Node{
		
		char id;
		Node left;
		Node right;
		private Node(char id) {
			this.id=id;
		}
	}
	
	
	public List<Character> postOrder(Node root) {
		LinkedList<Node> stack=new LinkedList<Node>();
		LinkedList<Character> result=new LinkedList<>();
		if(root!=null) {
			stack.add(root);
		}
		
		while(!stack.isEmpty()) {
			Node node=stack.pollLast();
			
			result.addFirst(node.id);
			
			if(node.left!=null) {
				stack.add(node.left);
			}
			if(node.right!=null) {
				stack.add(node.right);
			}
			
			
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		PostOrder po=new PostOrder();
		
		Node root=new Node('F');
		
		root.left=new Node('B');
		root.right=new Node('G');
		
		root.left.left=new Node('A');
		root.left.right=new Node('D');
		root.left.right.left=new Node('C');
		root.left.right.right=new Node('E');
		
		root.right.right=new Node('I');
		root.right.right.left=new Node('H');
		
		
		List<Character> results=po.postOrder(root);
		System.out.println(results);
	}
}
