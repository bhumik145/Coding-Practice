package treesandgraphs;

public class TreeNode<T> implements Comparable<TreeNode<T>> {

	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	int size = 1;

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
		return "[ " + data + " ] " + " , size: " + this.size + "  ";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
