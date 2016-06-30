package treesandgraphs;

public class CreateBinaryTreeFromSortedArray {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		tree.insert(50).insert(40).insert(100).insert(45).insert(60).insert(110).insert(10).insert(20);
		tree.inOrderTraversal(tree.root);
	}

}
