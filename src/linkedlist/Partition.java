package linkedlist;

public class Partition {

	public static <T extends Number> void partitionLinkedListBasedOnGivenPivot(LinkedList<T> list, T pivot) {

		if (null == list || null == list.getHead() || null == pivot) {
			return;
		}

		Node<T> finalHead = list.getHead();
		Node<T> traverse = list.getHead().next;
		Node<T> next = null;

		while (traverse != null) {
			next = traverse.next;
			if (traverse.data.intValue() < pivot.intValue()) {
				traverse.previous.next = traverse.next;
				if (null != traverse.next) {
					traverse.next.previous = traverse.previous;
				}
				traverse.next = finalHead;
				finalHead.previous = traverse;
				finalHead = traverse;
				finalHead.previous = null;
			}
			traverse = next;
		}
		list.setHead(finalHead);
	}

	public static void main(String[] args) {

		Node<Integer> head = new Node<>(10);
		LinkedList<Integer> list = new LinkedList<>(head);
		list.addNodeAtEnd(20).addNodeAtEnd(200).addNodeAtEnd(2).addNodeAtEnd(30).addNodeAtEnd(40).addNodeAtEnd(50)
				.addNodeAtEnd(60).addNodeAtEnd(4).addNodeAtEnd(10);

		list.traverseList();

		partitionLinkedListBasedOnGivenPivot(list, 40);

		list.traverseList();
	}

}
