package graph.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
	
	public boolean hasPathBFS(int source, int destination) {
		return hasPathBFS(getNode(source),getNode(destination));
		
	}
	private boolean hasPathBFS(Node source, Node destination) {
		List<Node> nextToVisit=new LinkedList<Node>();
		
		Set<Integer> visited=new HashSet<Integer>();
		
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()) {
			Node node=nextToVisit.remove(1);
			if(node==destination) {
				return true;
			}
			if(visited.contains(node.id)) {
				continue;
			}
			visited.add(node.id);
			
			for(Node child : node.adjacentNodes) {
				nextToVisit.add(child);
			}
		}
		return false;
	}
}
