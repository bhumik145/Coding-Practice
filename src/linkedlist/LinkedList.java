package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList<T> {

	private Node<T> head;
	private boolean isSingly;

	public LinkedList(Node<T> head, boolean isSingly) {
		this.head = head;
		this.isSingly = isSingly;
	}

	public LinkedList(Node<T> head) {
		this(head, false);
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public boolean isSingly() {
		return isSingly;
	}

	public void setSingly(boolean isSingly) {
		this.isSingly = isSingly;
	}

	public LinkedList<T> addNodeAtEnd(Node<T> node) {
		Node<T> traverse = head;
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

	public LinkedList<T> addNodeAtEnd(T data) {
		return addNodeAtEnd(new Node<T>(data));
	}

	public void traverseList() {
		Node<T> traverse = head;
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
		Node<T> traverse = head;

		while (traverse.getNext() != null && traverse.getNext().getNext() != null) {
			Node<T> previous = traverse.getPrevious();
			Node<T> nextTraverse = traverse.getNext().getNext();
			traverse.setPrevious(traverse.getNext());
			traverse.getNext().setNext(traverse);
			traverse.setNext(previous);
			traverse = nextTraverse;
		}

		Node<T> previous = traverse.getPrevious();
		Node<T> next = traverse.getNext();
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

	public LinkedList<T> removeDuplicatesWithExtraMemory() {
		Set<Node<T>> uniqueNodes = new HashSet<>();
		Node<T> traverse = head;
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

	public LinkedList<T> removeDuplicatesInMemory() {
		Node<T> current = head;
		while (current != null) {
			Node<T> traverse = current;
			while (traverse != null && traverse.next != null) {
				if (traverse.next.equals(current)) {
					traverse.setNext(traverse.next.next);
					if (null != traverse.getNext()) {
						traverse.next.previous = traverse;
					}
				}
				traverse = traverse.next;
			}
			current = current.next;
		}
		return this;
	}
}
