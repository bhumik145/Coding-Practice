package treesandgraphs;

import java.util.Random;

public class RandomNode {

	public static <T> TreeNode<T> getRandomNode(TreeNode<T> root) {
		Random random = new Random();
		int randomNumber = 0;
		while (randomNumber == 0) {
			randomNumber = random.nextInt(root.size);
		}
		return getIthNode(root, randomNumber);

	}

	public static <T> TreeNode<T> getIthNode(TreeNode<T> root, int i) {
		if (null == root) {
			return root;
		} else {
			int leftSize = 0;
			if (null != root.left) {
				leftSize = root.left.size;
			}
			if (leftSize == i - 1) {
				return root;
			} else if (leftSize > i - 1) {
				System.out.println("Switch left");
				return getIthNode(root.left, i);
			} else {
				System.out.println("swtich right");
				return getIthNode(root.right, i - (leftSize + 1));
			}
		}
	}

	public static <T> int setSizeOfAllNodes(TreeNode<T> root) {
		if (null == root) {
			return 0;
		} else {
			root.size = 1 + setSizeOfAllNodes(root.left) + setSizeOfAllNodes(root.right);
			return root.size;
		}
	}

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		TreeNode<Integer> root = new TreeNode<Integer>(50);
		tree.insert(root).insert(new TreeNode<Integer>(40)).insert(new TreeNode<Integer>(100))
				.insert(new TreeNode<Integer>(45)).insert(new TreeNode<Integer>(60)).insert(110)
				.insert(new TreeNode<Integer>(10)).insert(new TreeNode<Integer>(24));

		Tree.printLevelByLevel(root);

		setSizeOfAllNodes(root);

		Tree.printLevelByLevel(root);

		System.out.println("node: " + getIthNode(root, 2));
	}

}
