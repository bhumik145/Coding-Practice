
public class Permutations {

	public static void printAllPermutations(String str) {
		printAllPermutationsRec(str, "");
	}
	
	private static void printAllPermutationsRec(String str, String prefix) {
		if (str.isEmpty()) {
			System.out.println(prefix);
		} else {
			for (int index = 0; index < str.length(); index++) {
				String remaining = str.substring(0, index) + str.substring(index + 1);
				printAllPermutationsRec(remaining, prefix + str.charAt(index));
			}
		}
	}

	public static void main(String[] args) {
		printAllPermutations("abcd");
	}
}