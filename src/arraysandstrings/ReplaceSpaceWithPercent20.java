package arraysandstrings;

import java.util.Arrays;

public class ReplaceSpaceWithPercent20 {

	/**
	 * Replace space with %20, it is given that the char array representing the
	 * string has sufficient space at the end
	 * 
	 * Also, it should be noted that trailing spaces wont be replaced with %20
	 * in this solution, it's possible to replace them as well with spaces but
	 * that may require a little complex logic
	 * 
	 * @param input
	 */
	public static void replaceSpaceWithPercent20(char[] input) {

		int resultIndex = input.length - 1;
		int currentIndex = resultIndex;
		while (currentIndex >= 0 && input[currentIndex] == ' ') {
			currentIndex--;
		}
		while (currentIndex >= 0) {
			if (input[currentIndex] == ' ') {
				input[resultIndex--] = '0';
				input[resultIndex--] = '2';
				input[resultIndex--] = '%';
			} else {
				input[resultIndex--] = input[currentIndex];
			}
			currentIndex--;
		}
	}

	public static void main(String[] args) {

		char[] input = { 'A', ' ', ' ', 'B', ' ', 'C', ' ', ' ', ' ', ' ', ' ', ' '};

		replaceSpaceWithPercent20(input);
		System.out.println(Arrays.toString(input));
	}

}
