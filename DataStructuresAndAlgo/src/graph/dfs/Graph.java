package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

	private Map<Integer,Node> nodeLookup=new HashMap<Integer, Node>();
	
	public static class Node{
		private int id;
		List<Node> adjacentNodes=new ArrayList<Node>();
		private Node(int id) {
			this.id=id;
		}
	}
	
	private Node getNode(int id) {
		return nodeLookup.get(id);
	}
	
	public void addNode(int source, int destination) {
		Node s=getNode(source);
		Node d= getNode(destination);
		s.adjacentNodes.add(d);
	}
	
	public boolean hasPathDFS(int source, int destination) {
		
		Node s=getNode(source);
		Node d=getNode(destination);
		
		Set<Integer> visited =new HashSet<Integer>();
		return hasPathDFS(s,d,visited);
	}
	
	private boolean hasPathDFS(Node source, Node destination, Set<Integer> visited) {
		if(visited.contains(source)) {
			return false;
		}
		
		visited.add(source.id);
		if(source==destination) {
			return true;
		}
		for(Node child:source.adjacentNodes) {
			if(hasPathDFS(child, destination,visited)) {
				return true;
			}
		}
		
		return false;
		
	}
}
