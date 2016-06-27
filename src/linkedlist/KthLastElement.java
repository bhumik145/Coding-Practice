package linkedlist;

public class KthLastElement {

	public static <T> Node<T> getKthLastElementRec(Node<T> head, int k, Counter counter) {
		System.out.println("head: " + head + " count: " + counter);
		if (null == head) {
			System.out.println("base case");
			return head;
		} else {
			System.out.println("else case before recurstive call: " + head + " count: " + counter);

			Node<T> node = getKthLastElementRec(head.next, k, counter);

			System.out.println("else case after recurstive call: " + head + " count: " + counter + " node: " + node);

			counter.index += 1;
			if (k == counter.index) {
				System.out.println("found kth last element: " + head);
				return head;
			}
			return node;
		}
	}

	public static <T> Node<T> getKthLastElement(LinkedList<T> list, int k) {

		// Handle conditions for null, empty and size 1
		int count = 0;
		Node<T> traverse = list.getHead();
		Node<T> resultNode = traverse;
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
		Node<String> head = new Node<>("10");
		LinkedList<String> list = new LinkedList<>(head);
		list.addNodeAtEnd("20").addNodeAtEnd("30").addNodeAtEnd("40").addNodeAtEnd("20").addNodeAtEnd("40");

		list.traverseList();
		Counter counter = new KthLastElement.Counter(0);

		System.out.println(getKthLastElementRec(list.getHead(), 2, counter));
	}

	static class Counter {
		int index;

		public Counter(int index) {
			this.index = index;
		}

		@Override
		public String toString() {
			return "" + index;
		}
	}
}
