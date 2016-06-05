package hard.lineintersection;

import java.util.Arrays;

public class SmallestDifference {

	public static void findSmallestDifferencePair(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);

		int difference = Integer.MAX_VALUE;
		int currentDiff;
		int element1 = -1;
		int element2 = -1;
		for (int index1 = 0, index2 = 0; index1 < array1.length && index2 < array2.length;) {
			currentDiff = Math.abs(array1[index1] - array2[index2]);
			if (currentDiff < difference) {
				difference = currentDiff;
				element1 = array1[index1];
				element2 = array2[index2];
			}
			if (array1[index1] < array2[index2]) {
				index1++;
			} else {
				index2++;
			}
		}
		System.out.println("diff: " + difference + ", pair : (" + element1 + ", " + element2 + ")");
	}

	public static void main(String[] args) {

		int[] array1 = { 1, 3, 15, 11, 2 };
		int[] array2 = { 23, 127, 235, 19, 8 };
		findSmallestDifferencePair(array1, array2);
	}
}
