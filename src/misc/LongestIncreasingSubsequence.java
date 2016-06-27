package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-
 * subsequence/
 * 
 * The longest Increasing Subsequence (LIS) problem is to find the length of the
 * longest subsequence of a given sequence such that all elements of the
 * subsequence are sorted in increasing order. For example, length of LIS for {
 * 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * @author bthakkar
 *
 */
public class LongestIncreasingSubsequence {

	public static List<Integer> getLongestIncreasingSubsequence(List<Integer> numbers) {

		int size = numbers.size();
		Map<Integer, List<Integer>> subOptimalSequences = new HashMap<Integer, List<Integer>>();
		for (int i = size - 1; i >= 0; i--) {
			List<Integer> currentSubOptimalList = new ArrayList<Integer>();
			currentSubOptimalList.add(numbers.get(i));
			// Iterate over all numbers after current number, find the number
			// which is greater than current number and has highest count of
			// subOptimalSequence

			// Creating an instance just to avoid a null check while doing
			// add-all
			List<Integer> nextLongestSubSequence = new ArrayList<Integer>();
			int maxLength = Integer.MIN_VALUE;
			for (int j = i + 1; j < size; j++) {
				if (numbers.get(j) > numbers.get(i)) {
					if (maxLength < subOptimalSequences.get(j).size()) {
						maxLength = subOptimalSequences.get(j).size();
						nextLongestSubSequence = subOptimalSequences.get(j);
					}
				}
			}
			currentSubOptimalList.addAll(nextLongestSubSequence);
			subOptimalSequences.put(i, currentSubOptimalList);
		}

		int maxSize = Integer.MIN_VALUE;
		List<Integer> resultList = null;

		for (List<Integer> currentSubOptimalSequence : subOptimalSequences.values()) {
			if (maxSize < currentSubOptimalSequence.size()) {
				maxSize = currentSubOptimalSequence.size();
				resultList = currentSubOptimalSequence;
			}
		}
		return resultList;
	}

	public static void main(String[] args) {

		/**
		 * For example, length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
		 */
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(22);
		numbers.add(9);
		numbers.add(33);
		numbers.add(21);
		numbers.add(50);
		numbers.add(41);
		numbers.add(60);
		numbers.add(80);
		System.out.println(numbers);
		System.out.println("result: "+getLongestIncreasingSubsequence(numbers));
		
	}

}
