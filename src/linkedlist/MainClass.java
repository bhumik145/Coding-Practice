package linkedlist;

public class MainClass {

	public static void main(String[] args) {

		Node head = new Node("10");

		Node second = new Node("20");
		head.setNext(second);
		second.setPrevious(head);
		Node third = new Node("30");
		second.setNext(third);
		third.setPrevious(second);
		Node fourth = new Node("40");
		third.setNext(fourth);
		fourth.setPrevious(third);
		Node fifth = new Node("50");
		fourth.setNext(fifth);
		fifth.setPrevious(fourth);
		Node sixth = new Node("60");
		fifth.setNext(sixth);

		LinkedList list = new LinkedList(head);
		list.traverseList();

		list.reverseDoublyLinkedList();

		list.traverseList();
	}

}
