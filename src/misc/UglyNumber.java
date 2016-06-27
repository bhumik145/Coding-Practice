package misc;

/**
 * http://www.geeksforgeeks.org/ugly-numbers/
 * 
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By
 * convention, 1 is included. Write a program to find and print the 150’th ugly
 * number.
 * 
 * @author bthakkar
 *
 */
public class UglyNumber {

	public static int getNthUglyNumber(int n) {

		int[] uglyNumbers = new int[n];
		uglyNumbers[0] = 1;

		int indexOfNextNumberToBeMultipliedBy2 = 0;
		int indexOfNextNumberToBeMultipliedBy3 = 0;
		int indexOfNextNumberToBeMultipliedBy5 = 0;

		int nextMultipleOf2 = 0;
		int nextMultipleOf3 = 0;
		int nextMultipleOf5 = 0;

		int min;
		for (int index = 1; index < n; index++) {
			nextMultipleOf2 = uglyNumbers[indexOfNextNumberToBeMultipliedBy2] * 2;
			nextMultipleOf3 = uglyNumbers[indexOfNextNumberToBeMultipliedBy3] * 3;
			nextMultipleOf5 = uglyNumbers[indexOfNextNumberToBeMultipliedBy5] * 5;

			min = Math.min(Math.min(nextMultipleOf2, nextMultipleOf3), nextMultipleOf5);

			if (min == nextMultipleOf2) {
				indexOfNextNumberToBeMultipliedBy2++;
			}
			/**
			 * Not using else to automatically resolve the case: 2 * 3 = 3 * 2
			 */
			if (min == nextMultipleOf3) {
				indexOfNextNumberToBeMultipliedBy3++;
			}

			if (min == nextMultipleOf5) {
				indexOfNextNumberToBeMultipliedBy5++;
			}
			System.out.println("Adding ugly number: " + min + " at index: " + index);
			uglyNumbers[index] = min;
		}
		return uglyNumbers[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(getNthUglyNumber(150));
	}

}
