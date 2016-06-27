package linkedlist;

public class MainClass {

	public static void main(String[] args) {

		Node<String> head = new Node<>("10");
		LinkedList<String> list = new LinkedList<>(head);
		list.addNodeAtEnd("20").addNodeAtEnd("30").addNodeAtEnd("40").addNodeAtEnd("20").addNodeAtEnd("40");

		list.traverseList();

		list.removeDuplicatesInMemory();

		list.traverseList();
	}

}
