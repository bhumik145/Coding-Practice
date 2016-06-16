package arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class CheckForUniqueness {

	public static boolean isUniqueUsingBits(String str) {
		int checker = 0; // all 32 bits are zero
		for (char currentChar : str.toCharArray()) {
			int currentCharIntValue = currentChar - 'a';
			if ((checker & (1 << currentCharIntValue)) == 0) {
				checker = checker | 1 << currentCharIntValue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean isUnique(String str) {
		Set<Character> uniqueChars = new HashSet<>();
		for (char currentChar : str.toCharArray()) {
			if (uniqueChars.contains(currentChar)) {
				return false;
			} else {
				uniqueChars.add(currentChar);
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String str = "abccd";
		System.out.println("is " + str + " unique, bits: " + isUniqueUsingBits(str));
		System.out.println("is " + str + " unique, hashset: " + isUnique(str));

	}
}
