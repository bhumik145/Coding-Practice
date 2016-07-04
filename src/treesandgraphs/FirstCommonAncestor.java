package treesandgraphs;

public class FirstCommonAncestor {

	public static <T> TreeNode<T> findLCA(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2) {
		if (!covers(root, node1) || !covers(root, node2)) {
			// both nodes must be part of the tree
			return null;
		} else {
			return findLCARec(root, node1, node2);
		}
	}

	public static <T> TreeNode<T> findLCARec(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2) {
		if (null == root) {
			return root;
		} else {
			boolean isNode1OnLeftSide = covers(root.left, node1);
			boolean isNode2OnLeftSide = covers(root.left, node2);

			if (isNode1OnLeftSide && isNode2OnLeftSide) {
				// both are on either left or right side
				if (isNode1OnLeftSide) {
					return findLCARec(root.left, node1, node2);
				} else {
					return findLCARec(root.right, node1, node2);
				}
			} else {
				return root;
			}
		}
	}

	public static <T> TreeNode<T> findLCARecFaster(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2) {

		if (null == root) {
			return null;
		}

		if (root.equals(node1) || root.equals(node2)) {
			return root;
		}

		TreeNode<T> leftLCA = findLCARecFaster(root.left, node1, node2);
		System.out.println("left LCA : "+leftLCA);
		System.out.println("root: "+root);
		if (null != leftLCA && leftLCA != node1 && leftLCA != node2) {
			return leftLCA;
		}
		TreeNode<T> rightLCA = findLCARecFaster(root.right, node1, node2);
		System.out.println("left LCA : "+leftLCA);
		System.out.println("root: "+root);
		System.out.println("right LCA: "+rightLCA);
		if (null != rightLCA && rightLCA != node1 && rightLCA != node2) {
			return rightLCA;
		}
		if (leftLCA != null && rightLCA != null) {
			return root;
		} else if (root == leftLCA || root == rightLCA) {
			return root;
		} else {
			if (null != leftLCA) {
				return leftLCA;
			} else {
				return rightLCA;
			}
		}
	}

	public static <T> boolean covers(TreeNode<T> root, TreeNode<T> node) {

		if (null == root) {
			return false;
		} else {
			if (root.equals(node)) {
				return true;
			} else {
				return covers(root.left, node) || covers(root.right, node);
			}
		}
	}

	public static void main(String[] args) {

		Tree<Integer> tree = new Tree<>();
		TreeNode<Integer> root = new TreeNode<>(50);
		TreeNode<Integer> child = new TreeNode<>(20);
		tree.insert(root).insert(40).insert(100).insert(45).insert(60).insert(110).insert(10).insert(child).insert(24);
		Tree.printLevelByLevel(tree.root);

		System.out.println(covers(tree.root, new TreeNode<Integer>(20)));

		System.out.println(findLCA(tree.root, new TreeNode<Integer>(24), new TreeNode<Integer>(100)));
		
		System.out.println(findLCARecFaster(tree.root, new TreeNode<Integer>(24), new TreeNode<Integer>(100)));

	}

}
