package linkedlist;

public class Node {

	private String data;
	private Node next;
	private Node previous;

	public Node(String data) {
		this.data = data;
		this.previous = null;
		this.next = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "[ " + data + " ]";
	}
}
