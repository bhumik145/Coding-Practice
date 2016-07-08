import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static class Input implements Comparable<Input> {
		int start;
		int end;
		int number;

		Input(int start, int end, int number) {
			this.start = start;
			this.end = end;
			this.number = number;
		}

		@Override
		public int compareTo(Input o) {
			return Integer.compare(this.start, o.start);
		}

		@Override
		public String toString() {
			return "Input [start=" + start + ", end=" + end + ", number=" + number + "]";
		}

		
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int listSize = scan.nextInt();
		
		int numberOfOperations = scan.nextInt();
		int max = 0;

		int start ;
		int end;
		int numberToBeAdded;

		Input[] inputArray = new Input[numberOfOperations];
		for (int count = 0; count < numberOfOperations; count++) {
			start = scan.nextInt();
			end = scan.nextInt();
			numberToBeAdded = scan.nextInt();

			inputArray[count] = new Input(start, end, numberToBeAdded);

		}
		scan.close();

		Arrays.sort(inputArray);

		Input previous = inputArray[0];
		int finalMax = Integer.MIN_VALUE;
		max = previous.number;
		for (int index = 1; index < inputArray.length; index++) {
			if (inputArray[index].start <= previous.end) {
				max += inputArray[index].number;
			} else {
				max = inputArray[index].number;
			}
			finalMax = Math.max(finalMax, max);
		}

		System.out.println(finalMax);
	}


}
