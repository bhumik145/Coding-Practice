package hard;

import java.util.Arrays;

public class SwapNumbersInMemory {

	public static void swapTwoNumbers(int[] twoNumbers) {
		if (null == twoNumbers || twoNumbers.length != 2) {
			return;
		} else {
			twoNumbers[0] = twoNumbers[0] + twoNumbers[1];
			twoNumbers[1] = twoNumbers[0] - twoNumbers[1];
			twoNumbers[0] = twoNumbers[0] - twoNumbers[1];
		}
	}

	public static void swapUsingXOR(int[] numbers) {
		numbers[0] = numbers[0] ^ numbers[1]; // difference
		numbers[1] = numbers[1] ^ numbers[0]; // current number 2 XORed with
												// difference to get number 1
		numbers[0] = numbers[1] ^ numbers[0];
	}

	public static void main(String[] args) {
		int[] twoNumbers = { 2, 3 };
		System.out.println(Arrays.toString(twoNumbers));
		// swapTwoNumbers(twoNumbers);
		swapUsingXOR(twoNumbers);
		System.out.println(Arrays.toString(twoNumbers));
		/**
		 * output:
		 * 
		 * [2, 3]
		 * 
		 * [3, 2]
		 */
	}
}
