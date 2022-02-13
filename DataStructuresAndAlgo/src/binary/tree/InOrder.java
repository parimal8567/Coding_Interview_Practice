package binary.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class InOrder {

	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		private TreeNode(int x) {
			this.val=x;}
	}
	
	public List<Integer> inOrder(TreeNode root){
		
		
//		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		LinkedList<Integer> result=new LinkedList<Integer>();
		
		if(root==null) {
			return result;
		}
		
		TreeNode currentnode=root;
		while(currentnode!=null || !stack.isEmpty()) {
			
			while(currentnode!=null) {
				stack.push(currentnode);
				currentnode=currentnode.left;
			}
			
			
			currentnode=stack.pop();
			result.add(currentnode.val);
			
			currentnode=currentnode.right;
		}
		
		return result;
		
	}
	
	
	
	public static void main(String[] args) {
		InOrder io=new InOrder();
		
		TreeNode root=new TreeNode(3);
		
		TreeNode child1=new TreeNode(1);
		root.left=child1;
				
		TreeNode child2=new TreeNode(2);
		root.right=child2;
		
		List<Integer> results=io.inOrder(root);
		System.out.println(results);
		
		
	}
}
