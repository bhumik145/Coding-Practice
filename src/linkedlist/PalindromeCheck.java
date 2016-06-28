package linkedlist;

public class PalindromeCheck {

	public static boolean isPalindrom = true;

	public static <T> Node<T> isPalindrome(Node<T> node, int len) {
		if (len == 1 || len == 0) {
			return node;
		} else {
			// no need to do this, just for simplicity
			Node<T> current = node;
			Node<T> result = isPalindrome(node.next, len - 2);
			System.out.println("Comparing: current: " + current + ", result: " + result);
			isPalindrom &= current.equals(result);
			return result.next;
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.addNodeAtEnd(10).addNodeAtEnd(20).addNodeAtEnd(30).addNodeAtEnd(30).addNodeAtEnd(20);
		isPalindrome(list1.head, 5);
	}
}
