import java.util.Arrays;

public class MergeThreeSortedArrays {

	public int[] sortThreeArrays(int[] array1, int[] array2, int[] array3) {

		// Do the null and size-0 checks
		int[] finalArray = new int[array1.length + array2.length + array3.length];
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;

		while (index1 < array1.length || index2 < array2.length || index3 < array3.length) {
			if (index1 < array1.length && index2 < array2.length && index3 < array3.length) {

			} else if (index1 < array1.length && index2 < array2.length) {

			} else if (index1 < array1.length && index3 < array3.length) {

			} else if (index2 < array2.length && index3 < array3.length) {

			} else if (index1 < array1.length) {

			} else if (index2 < array2.length) {

			} else if (index3 < array3.length) {

			}
		}
		return null;
	}

	public static int[] sortNArrays(int[][] arrays) {

		int finalSize = 0;
		for (int[] row : arrays) {
			finalSize += row.length;
		}

		int[] finalArray = new int[finalSize];

		int[] indexes = new int[arrays.length];
		Arrays.fill(indexes, 0); // initialize all the indexes with zero

		for (int index = 0; index < finalSize; index++) {
			finalArray[index] = getNextElement(arrays, indexes);
		}
		return finalArray;
	}

	public static int getNextElement(int[][] arrays, int[] indexes) {

		// Get the array with index pointing to the minimum element
		int minElement = Integer.MAX_VALUE;
		int arrayHavingMinimumElementAtItsCurrentIndex = 0;
		for (int i = 0; i < indexes.length; i++) {
			if (arrays[i].length > indexes[i]) {
				if (minElement > arrays[i][indexes[i]]) {
					minElement = arrays[i][indexes[i]];
					arrayHavingMinimumElementAtItsCurrentIndex = i;
				}
			}
		}
		indexes[arrayHavingMinimumElementAtItsCurrentIndex]++;
		return minElement;
	}

	public static void main(String[] args) {

		int[] array1 = { 1, 5, 10, 30 };
		int[] array2 = { 12, 15, 16, 40 };
		int[] array3 = { 2, 3, 100, 300 };

		int[][] arrays = { array1, array2, array3 };
		
		System.out.println(Arrays.toString(sortNArrays(arrays)));

	}

}
