package treesandgraphs;

public class TreeNode<T> implements Comparable<TreeNode<T>> {

	T data;
	TreeNode<T> left;
	TreeNode<T> right;

	public TreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	public TreeNode() {
		this(null);
	}

	@Override
	public String toString() {
		return "[ " + data + " ] ";
	}

	@Override
	public int compareTo(TreeNode<T> other) {

		if (this.data.equals(other.data)) {
			return 0;
		} else {
			if (this.data instanceof Double) {
				return Double.compare((Double) this.data, (Double) other.data);
			} else if (this.data instanceof Integer) {
				return Integer.compare((Integer) this.data, (Integer) other.data);
			} else {
				return ((String) this.data).compareTo((String) other.data);
			}
		}
	}

}
