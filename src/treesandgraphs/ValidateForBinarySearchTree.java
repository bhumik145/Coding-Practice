package treesandgraphs;

public class ValidateForBinarySearchTree {

	public static <T> boolean isValidBinarySearchTree(TreeNode<T> node) {
		if (null == node) {
			return true;
		} else {
			boolean isLeftValid = isValidBinarySearchTree(node.left);
			boolean isRightValid = isValidBinarySearchTree(node.right);
			if (isLeftValid && isRightValid && isGivenNodeValidForBinarySearchTree(node)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static <T> boolean isGivenNodeValidForBinarySearchTree(TreeNode<T> node) {
		boolean isValid = true;
		if (null != node.left) {
			// node should be greater than or equal to it's left
			if (node.compareTo(node.left) < 0) {
				isValid = false;
			}
		}
		if (null != node.right) {
			// node should be less than it's right
			if (node.compareTo(node.right) >= 0) {
				isValid = false;
			}
		}
		return isValid;
	}

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		tree.insert(50).insert(40).insert(100).insert(45).insert(60).insert(110).insert(10).insert(20).insert(24);
		TreeNode<Integer> newNode = new TreeNode<>(200);
		tree.insert(newNode);
		
		TreeNode<Integer> unbalancedNode = new TreeNode<>(300);
		newNode.left = unbalancedNode;
		
		Tree.printLevelByLevel(tree.root);
		System.out.println("isValid binary search tree: "+isValidBinarySearchTree(tree.root));

	}

}
