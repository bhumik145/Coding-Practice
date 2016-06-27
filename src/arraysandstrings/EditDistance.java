package arraysandstrings;

public class EditDistance {

	public static boolean isEditDistanceLessThan2Smart(String first, String second) {

		int len1 = first.length();
		int len2 = second.length();

		if (len1 == len2) {
			// check for one replace
			if (getNumberOfReplacedRequired(first, second) > 1) {
				return false;
			} else {
				return true;
			}
		} else if (Math.abs(len1 - len2) == 1) {
			// Check for insert/remove
			boolean isOneInsertEnough = false;
			if (len1 < len2) {
				isOneInsertEnough = isOneInsertEnough(first, second);
			} else {
				isOneInsertEnough = isOneInsertEnough(second, first);
			}
			return isOneInsertEnough;
		} else {
			return false;
		}
	}

	public static int getNumberOfReplacedRequired(String first, String second) {
		int totalReplaces = 0;
		for (int index = 0; index < first.length(); index++) {
			if (first.charAt(index) != second.charAt(index)) {
				totalReplaces++;
			}
		}
		return totalReplaces;
	}

	public static boolean isOneInsertEnough(String small, String big) {
		int numberOfInserts = 0;

		for (int index1 = 0, index2 = 0; index1 < small.length() && index2 < big.length();) {
			if (small.charAt(index1) != big.charAt(index2)) {
				numberOfInserts++;
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return numberOfInserts <= 1;
	}

	public static void main(String[] args) {
		String str1 = "pale";
		String str2 = "cale";
		System.out.println(isEditDistanceLessThan2Smart(str1, str2));
	}

}
