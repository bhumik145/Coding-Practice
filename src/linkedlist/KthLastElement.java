package linkedlist;

public class KthLastElement {

	public static Node getKthLastElement(LinkedList list, int k) {

		// Handle conditions for null, empty and size 1
		int count = 0;
		Node traverse = list.getHead();
		Node resultNode = traverse;
		while (traverse != null) {
			if (count >= k) {
				resultNode = resultNode.next;
			}
			traverse = traverse.next;
			count++;
		}
		if (count < k) {
			System.out.println("Linked list's size is less than k. Linked list's size: " + count);
		}
		return resultNode;
	}

	public static void main(String[] args) {
		Node head = new Node("10");
		LinkedList list = new LinkedList(head);
		list.addNodeAtEnd("20").addNodeAtEnd("30").addNodeAtEnd("40").addNodeAtEnd("20").addNodeAtEnd("40");

		list.traverseList();

		System.out.println(getKthLastElement(list, 1));

	}
}
