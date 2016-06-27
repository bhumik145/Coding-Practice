package linkedlist;

public class DeleteMiddleElement {

	public static <T> void deleteMiddleElement(LinkedList<T> list) {

		if (null == list || null == list.getHead()) {
			return;
		}
		// only one element
		if (null == list.getHead().next) {
			list.setHead(null);
			return;
		}

		Node<T> traverse = list.getHead();
		Node<T> runner = traverse;

		while (null != runner && null != runner.next) {
			runner = runner.next.next;
			traverse = traverse.next;
		}

		// traverse is middle element
		System.out.println("Deleting : " + traverse);
		traverse.previous.next = traverse.next;
		if (null != traverse.next) {
			traverse.next.previous = traverse.previous;
		}
	}

	public static void main(String[] args) {
		Node<String> head = new Node<>("10");
		LinkedList<String> list = new LinkedList<>(head);
		list.addNodeAtEnd("20").addNodeAtEnd("30").addNodeAtEnd("40").addNodeAtEnd("20").addNodeAtEnd("40")
				.addNodeAtEnd("50");
		list.traverseList();
		deleteMiddleElement(list);
		list.traverseList();
		deleteMiddleElement(list);
		list.traverseList();
		deleteMiddleElement(list);
		list.traverseList();
		deleteMiddleElement(list);
		list.traverseList();
		deleteMiddleElement(list);
		list.traverseList();
		deleteMiddleElement(list);
		list.traverseList();
		deleteMiddleElement(list);
		list.traverseList();
		deleteMiddleElement(list);
		list.traverseList();
		deleteMiddleElement(list);
		list.traverseList();

		/**
		 * output: [ 10 ] -> [ 20 ] -> [ 30 ] -> [ 40 ] -> [ 20 ] -> [ 40 ] -> [
		 * 50 ] ->
		 * 
		 * Deleting : [ 40 ]
		 * 
		 * [ 10 ] -> [ 20 ] -> [ 30 ] -> [ 20 ] -> [ 40 ] -> [ 50 ] ->
		 * 
		 * Deleting : [ 20 ]
		 * 
		 * [ 10 ] -> [ 20 ] -> [ 30 ] -> [ 40 ] -> [ 50 ] ->
		 * 
		 * Deleting : [ 30 ]
		 * 
		 * [ 10 ] -> [ 20 ] -> [ 40 ] -> [ 50 ] ->
		 * 
		 * Deleting : [ 40 ]
		 * 
		 * [ 10 ] -> [ 20 ] -> [ 50 ] ->
		 * 
		 * Deleting : [ 20 ]
		 * 
		 * [ 10 ] -> [ 50 ] ->
		 * 
		 * Deleting : [ 50 ]
		 * 
		 * [ 10 ] ->
		 */
	}

}
