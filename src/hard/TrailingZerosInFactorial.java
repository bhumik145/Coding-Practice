package hard;

public class TrailingZerosInFactorial {

	public static int getNumberOfTrailingZerosInFactorialOfAGivenNumber(int number) {
		int numberOfTrailingZeros = 0;
		while (number >= 5) {
			number /= 5;
			numberOfTrailingZeros += number;
		}
		return numberOfTrailingZeros;
	}

	public static int getNumberOfTrailingZerosInefficient(int number) {
		int numberOfTrailingZeros = 0;
		long factorial = getFactorial(number);
		while (factorial >= 10 && factorial % 10 == 0) {
			factorial /= 10;
			numberOfTrailingZeros++;
		}
		return numberOfTrailingZeros;
	}

	public static long getFactorial(int number) {
		long factorial = 1;
		while (number > 0) {
			factorial *= number;
			number--;
		}
		return factorial;
	}

	public static void main(String[] args) {
		int number = 25;
		System.out.println("Factorial : " + getFactorial(number));
		System.out.println("Efficient: " + getNumberOfTrailingZerosInFactorialOfAGivenNumber(number));
		System.out.println("Inefficient: " + getNumberOfTrailingZerosInefficient(number));

	}
}
