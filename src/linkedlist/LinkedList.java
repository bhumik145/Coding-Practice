package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

	private Node head;
	private boolean isSingly;

	public LinkedList(Node head, boolean isSingly) {
		this.head = head;
		this.isSingly = isSingly;
	}

	public LinkedList(Node head) {
		this(head, false);
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public boolean isSingly() {
		return isSingly;
	}

	public void setSingly(boolean isSingly) {
		this.isSingly = isSingly;
	}

	public LinkedList addNodeAtEnd(Node node) {
		Node traverse = head;
		// go till the end
		while (traverse.getNext() != null) {
			traverse = traverse.getNext();
		}
		traverse.setNext(node);
		if (!isSingly) {
			node.setPrevious(traverse);
		}
		return this;
	}

	public LinkedList addNodeAtEnd(String data) {
		return addNodeAtEnd(new Node(data));
	}

	public void traverseList() {
		Node traverse = head;
		while (traverse != null) {
			System.out.print(traverse + " -> ");
			traverse = traverse.getNext();
		}
		System.out.println();
	}

	public void reverseLinkedList() {

	}

	public void reverseSinglyLinkedList() {

	}

	public void reverseDoublyLinkedList() {
		if (null == head || null == head.getNext()) {
			return;
		}
		Node traverse = head;

		while (traverse.getNext() != null && traverse.getNext().getNext() != null) {
			Node previous = traverse.getPrevious();
			Node nextTraverse = traverse.getNext().getNext();
			traverse.setPrevious(traverse.getNext());
			traverse.getNext().setNext(traverse);
			traverse.setNext(previous);
			traverse = nextTraverse;
		}

		Node previous = traverse.getPrevious();
		Node next = traverse.getNext();
		if (next != null) {
			traverse.setPrevious(traverse.getNext());
			traverse.getNext().setNext(traverse);
			traverse.setNext(previous);
			head = next;
		} else {
			traverse.setPrevious(traverse.getNext());
			traverse.setNext(previous);
			head = traverse;
		}
	}

	public LinkedList removeDuplicatesWithExtraMemory() {
		Set<Node> uniqueNodes = new HashSet<>();
		Node traverse = head;
		while (traverse != null) {
			if (uniqueNodes.contains(traverse)) {
				traverse.getPrevious().setNext(traverse.getNext());
				if (null != traverse.getNext()) {
					traverse.getNext().setPrevious(traverse.getPrevious());
				}
			} else {
				uniqueNodes.add(traverse);
			}
			traverse = traverse.getNext();
		}
		return this;
	}

	public LinkedList removeDuplicatesInMemory() {
		Node current = head;
		while (current != null && current.getNext() != null) {
			Node traverse = current.getNext();
			while (traverse != null) {
				if (traverse.equals(current)) {
					traverse.getPrevious().setNext(traverse.getNext());
					if (null != traverse.getNext()) {
						traverse.getNext().setPrevious(traverse.getPrevious());
					}
				}
				traverse = traverse.getNext();
			}
			current = current.getNext();
		}
		return this;
	}
}
