package treesandgraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Tree<T> {

	TreeNode<T> root;

	public static <T> void inOrderTraversal(TreeNode<T> node) {
		if (null == node) {
			return;
		} else {
			inOrderTraversal(node.left);
			System.out.println(node);
			inOrderTraversal(node.right);
		}
	}

	public static <T> void inOrderTraversalIterative(TreeNode<T> node) {

		if (null == node) {
			return;
		} else {
			Stack<TreeNode<T>> stack = new Stack<>();
			stack.add(node);

			TreeNode<T> current = node;

			while (null != current) {
				stack.push(current);
				current = current.left;
			}

			while (!stack.isEmpty()) {
				current = stack.pop();
				System.out.println(current);
				if (current.right != null) {
					current = current.right;
					while (current != null) {
						stack.push(current);
						current = current.left;
					}
				}
			}

		}
	}

	public Tree<T> insert(T data) {
		TreeNode<T> newNode = new TreeNode<>(data);
		return insert(newNode);
	}

	public Tree<T> insert(TreeNode<T> newNode) {

		if (null == root) {
			this.root = newNode;
			return this;
		} else {
			// Find a proper spot for new node
			// if a > b, compareTo(a,b) > 0
			TreeNode<T> traverse = root;
			TreeNode<T> previous = root;
			while (null != traverse) {
				previous = traverse;
				if (newNode.compareTo(traverse) > 0) {
					// go right
					traverse = traverse.right;
				} else {
					// go left
					traverse = traverse.left;
				}
			}
			if (newNode.compareTo(previous) > 0) {
				// New node should go right
				previous.right = newNode;
			} else {
				// left
				previous.left = newNode;
			}
		}
		return this;
	}

	public static <T> void printLevelByLevel(TreeNode<T> root) {
		if (null == root) {
			return;
		}

		List<TreeNode<T>> nodesAtCurrentLevel = new ArrayList<>();
		nodesAtCurrentLevel.add(root);

		List<TreeNode<T>> nodesAtNextLevel;

		Set<TreeNode<T>> visitedNodes = new HashSet<>();
		int level = 0;
		do {
			System.out.print("Level : " + level + "  ->  ");
			nodesAtNextLevel = new ArrayList<>();
			for (TreeNode<T> node : nodesAtCurrentLevel) {
				if (!visitedNodes.contains(node)) {
					visitedNodes.add(node);
					System.out.print(node + "  ");
					if (null != node.left) {
						nodesAtNextLevel.add(node.left);
					}
					if (null != node.right) {
						nodesAtNextLevel.add(node.right);
					}
				}
			}
			nodesAtCurrentLevel = nodesAtNextLevel;
			level++;
			System.out.println();
		} while (!nodesAtNextLevel.isEmpty());
	}

}
