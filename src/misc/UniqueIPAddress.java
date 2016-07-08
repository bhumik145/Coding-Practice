package misc;

import java.util.HashMap;
import java.util.Map;

import linkedlist.Node;

/**
 * https://www.careercup.com/question?id=5696959378620416
 * 
 * @author bthakkar
 *
 */
public class UniqueIPAddress {

	public static void printUniqueIPAddress(String[][] mapping) {

		Map<String, Node<String>> visited = new HashMap<>();
		Node<String> currentNode = null;
		Node<String> nextNode = null;
		for (int row = 0; row < mapping.length; row++) {
			if (visited.containsKey(mapping[row][0])) {
				currentNode = visited.get(mapping[row][0]);
				nextNode = new Node<>(mapping[row][1]);
			} else if (visited.containsKey(mapping[row][1])) {
				currentNode = visited.get(mapping[row][1]);
				nextNode = new Node<>(mapping[row][0]);
			} else {
				// both nodes are new in this pair
				currentNode = new Node<>(mapping[row][0]);
				nextNode = new Node<>(mapping[row][1]);
				visited.put(currentNode.data, currentNode);
			}
			appendNodeAfterGivenNode(currentNode, nextNode);
			visited.put(nextNode.data, nextNode);
		}

		for (Node<String> node : visited.values()) {
			if (null == node.previous) {
				System.out.println(node.data);
			}
		}
	}

	public static <T> void appendNodeAfterGivenNode(Node<T> currentNode, Node<T> nextNode) {
		if (null == currentNode.next) {
			currentNode.next = nextNode;
		} else {
			Node<T> copyOfCurrentNext = currentNode.next;
			currentNode.next = nextNode;
			nextNode.next = copyOfCurrentNext;
			copyOfCurrentNext.previous = nextNode;
		}
		nextNode.previous = currentNode;
	}

	public static void main(String[] args) {
		String[][] mapping = { { "IP1", "IP2" }, { "IP3", "IP2" }, { "IP5", "IP4" }, { "IP6", "IP5" }, { "IP5", "IP9" },
				{ "IP7", "IP8" }, { "IP9", "IP10" } };
		printUniqueIPAddress(mapping);
	}

}
