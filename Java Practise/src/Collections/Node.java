package Collections;

public class Node {

	int value;
	Node node;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + ", node=" + node + "]";
	}
	
}
