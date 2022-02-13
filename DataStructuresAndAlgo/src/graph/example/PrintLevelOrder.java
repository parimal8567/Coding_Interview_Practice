package graph.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintLevelOrder {

	public static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        
        if(root==null) {
        	return result;
        }
        queue.add(root);
        List<Integer> levelNodes=new ArrayList<Integer>();
        while(!queue.isEmpty()) {
        	
        	TreeNode node=queue.poll();
        	levelNodes.add(node.val);
        	
        	if(node.left!=null) {
        		queue.add(node.left);
        		levelNodes.add(node.left.val);
        	}
        	
        	if(node.right!=null) {
        		queue.add(node.right);
        		levelNodes.add(node.right.val);
        	}
        
        	}
        return result;
    }
	
	public static void main(String[] args) {
		PrintLevelOrder plo=new PrintLevelOrder();
		TreeNode root=new TreeNode(1);
		
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		
		List<List<Integer>> answers=plo.levelOrder(root);
		System.out.println(answers.toString());
//		for(List<Integer> level:answers) {
//			for()
//		}
	}
}
