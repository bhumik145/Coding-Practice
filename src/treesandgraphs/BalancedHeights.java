package treesandgraphs;

public class BalancedHeights {

	public static boolean isBalanced = true;

	public static <T> int checkForBalancedHeight(TreeNode<T> node) {

		if (null == node) {
			return 0;
		} else {
			int leftHeight = 1 + checkForBalancedHeight(node.left);
			int rightHeight = 1 + checkForBalancedHeight(node.right);
			// do a check for isBalanced before proceeding, intentionally
			// traversing full tree
			if (Math.abs(leftHeight - rightHeight) > 1) {
				isBalanced = false;
			}
			return Math.max(leftHeight, rightHeight);
		}
	}

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		tree.insert(50).insert(40).insert(100).insert(45).insert(60).insert(110).insert(10).insert(20).insert(24);
		Tree.printLevelByLevel(tree.root);

		System.out.println("height: " + checkForBalancedHeight(tree.root));
		System.out.println("Is balanced: " + isBalanced);
	}

}
