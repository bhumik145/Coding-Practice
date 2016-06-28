package linkedlist;

public class SumLL {

	static class NodeWithCarry {
		Node<Integer> node;
		int carry;

		public NodeWithCarry(Node<Integer> node) {
			this.node = node;
			carry = 0;
		}

		public NodeWithCarry() {
			this.node = null;
			carry = 0;
		}
	}

	public static LinkedList<Integer> sumTwoLLWhereUnitDigitIsTail(LinkedList<Integer> list1,
			LinkedList<Integer> list2) {

		LinkedList<Integer> resultList = null;
		if (null == list1 || null == list1.head) {
			return list2;
		} else if (null == list2 || null == list2.head) {
			return list1;
		} else {
			NodeWithCarry nodeWithCarry1 = new NodeWithCarry(list1.head);

			NodeWithCarry nodeWithCarry2 = new NodeWithCarry(list2.head);
			NodeWithCarry resultNodeWithCarry = sumRec(nodeWithCarry1, nodeWithCarry2);
		}
		return resultList;
	}

	/**
	 * Recursive approach where unit digit is at the tail
	 * 
	 * 
	 * TODO, add a method equal the lengths of both the lists
	 * 
	 * @param node1
	 * @param node2
	 * @param carry
	 * @return
	 */
	public static NodeWithCarry sumRec(NodeWithCarry node1, NodeWithCarry node2) {

//		if (null == node1 && null == node2) {
//			return null;
//		} else {
//
//			Node<Integer> prevNode = sumRec(node1.next, node2.next, carry);
//
//			int dataForNewNode = carry;
//			if (null != node1) {
//				dataForNewNode += node1.data;
//			}
//
//			if (null != node1) {
//				dataForNewNode += node2.data;
//			}
//
//			if (dataForNewNode >= 10) {
//				dataForNewNode -= 10;
//				carry = 1;
//			} else {
//				carry = 0;
//			}
//
//			Node<Integer> newNode = new Node<>(dataForNewNode);
//
//			if (null != prevNode) {
//				prevNode.next = newNode;
//				return prevNode;
//			}
//
//			return newNode;
//		}
		return null;
	}

	/**
	 * Recursive approach where unit digit is at the head
	 * 
	 * @param node1
	 * @param node2
	 * @param carry
	 * @return
	 */
	public static Node<Integer> sumLLWhereUnitDigitIsHead(Node<Integer> node1, Node<Integer> node2, int carry) {

		if (null == node1 && null == node2 && carry == 0) {
			return null;
		} else {

			int nodeData = carry;

			if (null != node1) {
				nodeData += node1.data;
			}

			if (null != node2) {
				nodeData += node2.data;
			}

			if (nodeData >= 10) {
				nodeData -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			Node<Integer> newNode = new Node<>(nodeData);
			Node<Integer> nextNode = sumLLWhereUnitDigitIsHead(node1 == null ? null : node1.next,
					node2 == null ? null : node2.next, carry);
			newNode.next = nextNode;
			return newNode;
		}

	}

	/**
	 * Unit digit is the head of the list
	 * 
	 * Lists are stored in reverse order, i.e for number 697,
	 * 
	 * list will be 7 ->9 -> 6
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static LinkedList<Integer> sumTwoLLWhereUnitDigitIsHead(LinkedList<Integer> list1,
			LinkedList<Integer> list2) {

		LinkedList<Integer> resultList = null;
		if (null == list1 || null == list1.head) {
			return list2;
		} else if (null == list2 || null == list2.head) {
			return list1;
		} else {
			int dataForResultHead = list1.head.data + list2.head.data;

			int carry = 0;

			if (dataForResultHead >= 10) {
				dataForResultHead -= 10;
				carry = 1;
			}
			Node<Integer> head = new Node<>(dataForResultHead);
			resultList = new LinkedList<>(head);

			Node<Integer> traverse1 = list1.head.next;
			Node<Integer> traverse2 = list2.head.next;
			int currentSum;
			while (null != traverse1 || null != traverse2 || carry != 0) {

				currentSum = carry;

				if (null != traverse1) {
					currentSum += traverse1.data;
					traverse1 = traverse1.next;
				}

				if (null != traverse2) {
					currentSum += traverse2.data;
					traverse2 = traverse2.next;
				}

				if (currentSum >= 10) {
					carry = 1;
					currentSum -= 10;
				} else {
					carry = 0;
				}

				Node<Integer> newNode = new Node<>(currentSum);
				resultList.addNodeAtEnd(newNode);
			}
		}
		return resultList;
	}

	public static LinkedList<Integer> createListFromNumberWithUnitDigitAsHead(int number) {

		LinkedList<Integer> resultList = new LinkedList<Integer>();

		while (number > 0) {
			resultList.addNodeAtEnd(number % 10);
			number /= 10;
		}
		return resultList;
	}

	public static int createNumberFromLLWhereUnitDigitIsHead(LinkedList<Integer> list) {
		int sum = 0;

		int power = 0;

		Node<Integer> traverse = list.head;

		while (null != traverse) {
			sum += traverse.data * Math.pow(10, power);
			power++;
			traverse = traverse.next;
		}

		return sum;
	}

	public static void main(String[] args) {

		// int number1 = 597;
		//
		// LinkedList<Integer> list1 =
		// createListFromNumberWithUnitDigitAsHead(number1);
		//
		// list1.traverseList();
		//
		// int number2 = 7983;
		//
		// LinkedList<Integer> list2 =
		// createListFromNumberWithUnitDigitAsHead(number2);
		//
		// list2.traverseList();
		//
		// LinkedList<Integer> resultList = sumTwoLLWhereUnitDigitIsHead(list1,
		// list2);
		//
		// System.out.println("result list: ");
		// resultList.traverseList();
		//
		// int expectedSum = number1 + number2;
		//
		// int receivedSum = createNumberFromLLWhereUnitDigitIsHead(resultList);
		//
		// System.out.println("expected sum: " + expectedSum);
		// System.out.println("received sum: " + receivedSum);
		//
		// System.out.println("did the algo work? " + (expectedSum ==
		// receivedSum));

		/**
		 * For LL where unit digit is head, using recursion.
		 */

		// number 765
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.addNodeAtEnd(5).addNodeAtEnd(6).addNodeAtEnd(7);

		// number 589
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.addNodeAtEnd(9).addNodeAtEnd(8).addNodeAtEnd(5);

		list1.traverseList();
		list2.traverseList();
		Node<Integer> resultNode = sumLLWhereUnitDigitIsHead(list1.head, list2.head, 0);
		LinkedList<Integer> resultList = new LinkedList<>(resultNode);

		resultList.traverseList();

		/**
		 * For LL where unit digit is the last node
		 */

		// // number 567
		// LinkedList<Integer> list1 = new LinkedList<>();
		//
		// list1.addNodeAtEnd(5).addNodeAtEnd(6).addNodeAtEnd(7);
		//
		// // number 985
		// LinkedList<Integer> list2 = new LinkedList<>();
		//
		// list2.addNodeAtEnd(9).addNodeAtEnd(8).addNodeAtEnd(5);
		//
		// list1.traverseList();
		// list2.traverseList();
		//
		// Node<Integer> resultHead = sumRec(list1.head, list2.head, 0);
		//
		// // result, expected
		// LinkedList<Integer> resultList = new LinkedList<>(resultHead);
		// resultList.traverseList();
	}
}
