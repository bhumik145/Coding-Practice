package treesandgraphs;

import java.util.List;
import java.util.Map;

public class PathsWithSum {

	public static int totalPathsWithGivenSum(TreeNode<Integer> root, int targetSum, int currentRunningSum,
			Map<Integer, Integer> previousRunningSums) {
		if (null == root) {
			return 0;
		} else {
			currentRunningSum += root.data;
			int totalNumberOfPaths = 0;
			if (currentRunningSum == targetSum) {
				totalNumberOfPaths++;
			} else {
				if (previousRunningSums.containsKey(targetSum - currentRunningSum)) {
					totalNumberOfPaths += previousRunningSums.get(targetSum - currentRunningSum);
				} else {
					if (previousRunningSums.containsKey(currentRunningSum)) {
						previousRunningSums.put(currentRunningSum, previousRunningSums.get(currentRunningSum) + 1);
					} else {
						previousRunningSums.put(currentRunningSum, 1);
					}
				}
			}
			totalNumberOfPaths += totalPathsWithGivenSum(root.left, targetSum, currentRunningSum, previousRunningSums);
			totalNumberOfPaths += totalPathsWithGivenSum(root.right, targetSum, currentRunningSum, previousRunningSums);
			
			if (previousRunningSums.get(currentRunningSum) > 1) {
				previousRunningSums.put(currentRunningSum, previousRunningSums.get(currentRunningSum) - 1);
			} else {
				previousRunningSums.remove(currentRunningSum);
			}
			return totalNumberOfPaths;
		}
	}

	public static void main(String[] args) {

	}

}
