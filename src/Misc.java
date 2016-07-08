import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Misc {

	static String firstRepeatedWord(String s) {
		if (null == s || s.isEmpty()) {
			return null;
		}
		String[] words = s.split("(,+|;+|-+|:+|\\.+| +)");

		Set<String> visited = new HashSet<>();

		for (String word : words) {
			if (word.isEmpty()) {
				// This may happen is two words are separated by multiple
				// markers
				continue;
			}
			if (visited.contains(word)) {
				return word;
			} else {
				visited.add(word);
			}
		}
		return null;
	}

	static int[] mergeArrays(int[] a, int[] b) {
		if (null == a && null != b) {
			return b;
		}
		if (null == b && null != a) {
			return a;
		}
		if (null == a && null == b) {
			return null;
		}
		// more checks for emptiness before invoking the main business logic

		int[] mergedArray = new int[a.length + b.length];

		int index1 = 0;
		int index2 = 0;
		int resultIndex = 0;

		while (index1 < a.length && index2 < b.length) {
			if (a[index1] < b[index2]) {
				mergedArray[resultIndex] = a[index1];
				index1++;
			} else {
				mergedArray[resultIndex] = b[index2];
				index2++;
			}
			resultIndex++;
		}
		// Copy over from non-traversed array
		if (index1 < a.length) {
			while (index1 < a.length) {
				mergedArray[resultIndex] = a[index1];
				index1++;
				resultIndex++;
			}
		} else if (index2 < b.length) {
			while (index2 < b.length) {
				mergedArray[resultIndex] = b[index2];
				index2++;
				resultIndex++;
			}
		}
		return mergedArray;
	}

	public static void main(String[] args) {
//
//		String str = "abc:pqr;xyz   aa bb-cc.-dd,,ee,abc";
//		String[] words = str.split("(,+|;+|-+|:+|\\.+| +)");
//
//		for (String word : words) {
//			System.out.println(word);
//		}
//
//		System.out.println(firstRepeatedWord(str));
		
		int[]  a = {2,4,5,9,9};
		int[] b = {0,1,2,3,4};
		
		System.out.println(Arrays.toString(mergeArrays(a,b)));
	}
	

}
