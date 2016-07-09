package recursion;

public class Subsets {

	public static void printAllSubsets(String input, String output, int index) {
		if (index == input.length()) {
			System.out.println(output);
			return;
		} else {
			printAllSubsets(input, output, index+1);
			printAllSubsets(input, output + input.charAt(index), index+1);
		}
	}

	public static void printPermutations(String input, String output) {
		if (input.isEmpty()) {
			System.out.println(output);
			return;
		} else {
			for (int index = 0; index < input.length(); index++) {

				String prefix = input.substring(0, index);

				String suffix = input.substring(index + 1);

				printPermutations(prefix + suffix, output + input.charAt(index));

			}
		}
	}

	public static void main(String[] args) {
		//printPermutations("abc", "");
		
		printAllSubsets("abcd", "", 0);
	}

}
