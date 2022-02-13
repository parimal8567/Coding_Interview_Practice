package graph.bfs.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SetNextToNullLevelWise {


	 public Node connect(Node root) {
		 Queue<Node> queue=new LinkedList<Node>();
	     queue.add(root);
	      
	     while(queue.size()> 0) {
	    	 int size=queue.size();
	    	 
	    	 for(int i=0;i<size;i++) {
	    		 Node node=queue.poll();
	    		 if(i<size-1) {
	    			 node.next=queue.peek();
	    		 }
	    		 if(node.left!=null) {
	    			 queue.add(node.left);
	    		 }
	    		 if(node.right!=null) {
	    			 queue.add(node.right);
	    		 }
	    	 }
	      }
	      
	      return root;
	 }
	 
	 public Node connectOriginal(Node root) {
		 
		   if (root == null) {
	            return root;
	        }
	        
	        // Initialize a queue data structure which contains
	        // just the root of the tree
	        Queue<Node> Q = new LinkedList<Node>(); 
	        Q.add(root);
	        
	        // Outer while loop which iterates over 
	        // each level
	        while (Q.size() > 0) {
	            
	            // Note the size of the queue
	            int size = Q.size();
	            
	            // Iterate over all the nodes on the current level
	            for(int i = 0; i < size; i++) {
	                
	                // Pop a node from the front of the queue
	                Node node = Q.poll();
	                
	                // This check is important. We don't want to
	                // establish any wrong connections. The queue will
	                // contain nodes from 2 levels at most at any
	                // point in time. This check ensures we only 
	                // don't establish next pointers beyond the end
	                // of a level
	                if (i < size - 1) {
	                    node.next = Q.peek();
	                }
	                
	                // Add the children, if any, to the back of
	                // the queue
	                if (node.left != null) {
	                    Q.add(node.left);
	                }
	                if (node.right != null) {
	                    Q.add(node.right);
	                }
	            }
	        }
	        
	        // Since the tree has now been modified, return the root node
	        return root;
	 }
	 
	 
	
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.next=null;
		
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.left.next=null;
		root.left.next=null;
		
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		
		
		
		SetNextToNullLevelWise st=new SetNextToNullLevelWise();
		Node result=st.connect(root);
		System.out.println(result.toString());
		
	}
}
