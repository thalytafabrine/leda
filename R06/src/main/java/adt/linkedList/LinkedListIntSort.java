public class LinkedList {
	private Node head;
	
	public LinkedList() {
		this.head = null;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void insertionSort(int value) {
		Node newNode = new Node(value);
		if (this.isEmpty()) {
			this.head = newNode;
		} else if (this.head.value > newNode.value) {
			newNode.next = this.head;
			this.head.previous = newNode;
			this.head = newNode;
		} else {
			insertionSort(this.head, newNode);
		}
	}

	private void insertionSort(Node node, Node newNode) {
		if (node.next == null) {
			node.next = newNode;
			newNode.previous = node;
		} else if (node.next.value > newNode.value) {
			node.next.previous = newNode;
			newNode.next = node.next;
			node.next = newNode;
			newNode.previous = node;
		} else {
			insertionSort(node.next, newNode);
		}
				
	}
	
	public String toString() {
		if (this.isEmpty()) {
			return "";
		} else {
			return toString(this.head);
		}
	}

	private String toString(Node node) {
		if(node == null) {
			return "";
		} else {
			return node.value + " " + toString(node.next);
		}
		
	}

}

class Node {
	int value;
	Node next;
	Node previous;
	
	public Node(int value) {
		this.value = value;
		this.next = null;
		this.previous = null;
	}
}
