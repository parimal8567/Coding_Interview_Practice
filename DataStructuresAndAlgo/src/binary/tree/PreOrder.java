package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		private TreeNode(int x) {
			this.val=x;}
	}
	
	public List<Integer> preOrder(TreeNode root){
		
		
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		LinkedList<Integer> result=new LinkedList<Integer>();
		
		if(root==null) {
			return result;
		}
		
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode node=stack.pollFirst();

			result.add(node.val);
			
			if(node.left!=null) {
				stack.add(node.left);
			}
			
			if(node.right!=null) {
				stack.add(node.right);
			}
		}
		
		return result;
		
	}
	
	
	public List<Integer> preOrderOriginal(TreeNode root){
		   LinkedList<TreeNode> stack = new LinkedList<>();
		    LinkedList<Integer> output = new LinkedList<>();
		    if (root == null) {
		      return output;
		    }

		    stack.add(root);
		    while (!stack.isEmpty()) {
		      TreeNode node = stack.pollLast();
		      output.add(node.val);
		      if (node.right != null) {
		        stack.add(node.right);
		      }
		      if (node.left != null) {
		        stack.add(node.left);
		      }
		    }
		    return output;
	}
	
	
	public static void main(String[] args) {
		PreOrder po=new PreOrder();
		
		TreeNode root=new TreeNode(3);
		
		TreeNode child1=new TreeNode(1);
		root.left=child1;
				
		TreeNode child2=new TreeNode(2);
		root.right=child2;
		
		List<Integer> results=po.preOrder(root);
		System.out.println(results);
		
		
	}
	
	
}
