package treesandgraphs;

public class CreateBinaryTreeFromSortedArray {

	public static <T> TreeNode<T> createMinHieghtBinaryTree(T[] sortedArray, int start, int end) {
		if (start == end) {
			return new TreeNode<T>(sortedArray[start]);
		}
		if (start > end) {
			return null;
		} else {
			int mid = start + (end - start) / 2;
			TreeNode<T> newNode = new TreeNode<>(sortedArray[mid]);
			newNode.left = createMinHieghtBinaryTree(sortedArray, start, mid - 1);
			newNode.right = createMinHieghtBinaryTree(sortedArray, mid + 1, end);
			return newNode;
		}

	}

	public static void main(String[] args) {
		// Tree<Integer> tree = new Tree<>();
		// tree.insert(50).insert(40).insert(100).insert(45).insert(60).insert(110).insert(10).insert(20);
		// tree.inOrderTraversal(tree.root);

		Integer[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode<Integer> resultNode = createMinHieghtBinaryTree(sortedArray, 0, sortedArray.length - 1);
		Tree.inOrderTraversal(resultNode);

	}
}
