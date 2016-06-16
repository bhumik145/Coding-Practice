package arraysandstrings;

import util.ArrayUtil;

public class MatrixRotation {

	public static <T> void rotateBy90Degrees(T[][] matrix) {
		int rows = matrix.length - 1;
		int columns = matrix[0].length - 1;// Assumed that matrix is n X n

		int layers = rows / 2;

		for (int currentLayer = 0; currentLayer < layers; currentLayer++) {
			for (int currentRow = currentLayer; currentRow < rows - currentLayer; currentRow++) {
				T temp = matrix[currentLayer][currentRow];
				matrix[currentLayer][currentRow] = matrix[rows - currentRow][currentLayer];
				matrix[rows - currentRow][currentLayer] = matrix[rows - currentLayer][columns - currentRow];
				matrix[rows - currentLayer][columns - currentRow] = matrix[currentRow][columns - currentLayer];
				matrix[currentRow][columns - currentLayer] = temp;
			}
			ArrayUtil.print2DArray(matrix);
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Integer[][] array = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 }, { 13, 14, 15, 16 } };
		// Used Integer object as generics don't work fine on primitive types
		ArrayUtil.print2DArray(array);
		System.out.println();
		rotateBy90Degrees(array);

		ArrayUtil.print2DArray(array);
	}

}
