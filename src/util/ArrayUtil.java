package util;

public class ArrayUtil {

	public static <T> void print2DArray(T[][] array) {

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + "  ");
			}
			System.out.println();
		}

	}
}
