package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * example:
 * 
 * array1 = {1, 2}
 * 
 * array2 = {3, 4}
 * 
 * output : {1 , 2 , 3 , 4}; {1, 3, 4, 2}; {1,3, 2,4};{3, 4, 1, 2}; {3, 1 ,2,
 * 4}; {3, 4, 1 ,2}
 * 
 * 
 * Assume unique elements
 * 
 * 
 * This is known as weaving of elements.
 * 
 * 
 * @author bthakkar
 *
 */
public class MergeArrayCombinationsWithSequenceMaintained {

	public static void printMergedArrayWithSequenceMaintained(int[] array1, int[] array2, int index1, int index2,
			int[] result, int resultIndex, List<int[]> resultArrays) {

		if (index1 == array1.length && index2 == array2.length) {
			
			resultArrays.add(result.clone());
			System.out.println(Arrays.toString(result));
		} else {
			if (index1 <= array1.length - 1) {
				result[resultIndex] = array1[index1];
				printMergedArrayWithSequenceMaintained(array1, array2, index1 + 1, index2, result, resultIndex + 1,
						resultArrays);
			}

			if (index2 <= array2.length - 1) {
				result[resultIndex] = array2[index2];

				printMergedArrayWithSequenceMaintained(array1, array2, index1, index2 + 1, result, resultIndex + 1,
						resultArrays);
			}
		}
	}

	public static void main(String[] args) {

		int[] array1 = { 1, 2 };
		int[] array2 = { 3, 4 };

		int[] result = new int[array1.length + array2.length];

		List<int[]> resultArrays = new ArrayList<>();

		printMergedArrayWithSequenceMaintained(array1, array2, 0, 0, result, 0, resultArrays);
		
		System.out.println("From stored/cloned results");
		for (int[] array : resultArrays) {
			System.out.println(Arrays.toString(array));
		}
	}

}
