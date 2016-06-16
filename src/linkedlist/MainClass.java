package linkedlist;

public class MainClass {

	public static void main(String[] args) {

		Node head = new Node("10");
		LinkedList list = new LinkedList(head);
		list.addNodeAtEnd("20").addNodeAtEnd("30").addNodeAtEnd("40").addNodeAtEnd("20").addNodeAtEnd("40");

		list.traverseList();
		
		list.removeDuplicatesInMemory();
		
		list.traverseList();
	}

}
