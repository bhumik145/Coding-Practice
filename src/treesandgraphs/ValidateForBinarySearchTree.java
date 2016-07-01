package treesandgraphs;

public class ValidateForBinarySearchTree {

	public static boolean isValidBinarySearchTree(TreeNode<Integer> node, int min, int max) {

		if (null == node) {
			return true;
		} else {
			if (node.data >= min && node.data < max) {
				return isValidBinarySearchTree(node.left, min, node.data)
						&& isValidBinarySearchTree(node.right, node.data, max);
			} else {
				return false;
			}
		}

	}

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();

		tree.insert(50).insert(40).insert(100).insert(45).insert(60).insert(110).insert(10).insert(20).insert(24);
		TreeNode<Integer> newNode = new TreeNode<>(200);
		tree.insert(newNode);

		TreeNode<Integer> unbalancedNode = new TreeNode<>(22);
		newNode.left = unbalancedNode;

		Tree.printLevelByLevel(tree.root);
		System.out.println("isValid binary search tree: " + isValidBinarySearchTree(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

}
