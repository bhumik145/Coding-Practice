package treesandgraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
				System.out.println("Adding new node to the right of node : " + previous);
				previous.right = newNode;
			} else {
				// left
				System.out.println("Adding new node to the left of node : " + previous);
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
			System.out.print("Level : "+level + "  ->  ");
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
