package linkedlist;

public class SumLL {

	/**
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

		int number1 = 597;

		LinkedList<Integer> list1 = createListFromNumberWithUnitDigitAsHead(number1);

		list1.traverseList();

		int number2 = 7983;

		LinkedList<Integer> list2 = createListFromNumberWithUnitDigitAsHead(number2);

		list2.traverseList();

		LinkedList<Integer> resultList = sumTwoLLWhereUnitDigitIsHead(list1, list2);

		System.out.println("result list: ");
		resultList.traverseList();

		int expectedSum = number1 + number2;

		int receivedSum = createNumberFromLLWhereUnitDigitIsHead(resultList);

		System.out.println("expected sum: " + expectedSum);
		System.out.println("received sum: " + receivedSum);

		System.out.println("did the algo work? " + (expectedSum == receivedSum));

	}
}
