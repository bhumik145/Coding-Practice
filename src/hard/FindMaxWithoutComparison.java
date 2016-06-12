package hard;

public class FindMaxWithoutComparison {

	public static int flip(int bit) {
		return 1 ^ bit;
	}

	/*
	 * returns 1 if positive, 0 if negative
	 */
	public static int getSign(int number) {
		number = number >> 31; // Keep only last bit
		return flip(number & 1);
	}

	/**
	 * if a - b > 0, a > b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getMax(int a, int b) {
		int signOfAMinusB = getSign(a - b);
		int max = signOfAMinusB * a + flip(signOfAMinusB) * b;
		return max;
	}

	/**
	 * 
	 * In the above solution, condition of overflow is not addressed.
	 * 
	 * Overflow will happen when:
	 * 
	 * 1. a is positive and b is negative
	 * 
	 * 2. a is negative and b is positive
	 * 
	 * 
	 * in such case, the signOfAMinusB should be sign of a, i.e in case 1, a
	 * should be the answer, hence use a's sign i.e 1; in case 2, a is smaller
	 * hence a's sign is 0, hence answer will become b
	 * 
	 * In all other cases, i.e when the signs are the same, we depend on the
	 * sign of a - b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getMaxAddressOverflow(int a, int b) {

		int signOfA = getSign(a);
		int signOfB = getSign(b);
		int signOfAMinusB = getSign(a - b);

		int areSignsOfABDifferent = signOfA ^ signOfB; // If same, answer is 0,
														// if different 1
		// if areSignsOfABDifferent = 1, use a's sign, else use signOfAMinusB
		int finalSignOperator = areSignsOfABDifferent * signOfA + flip(areSignsOfABDifferent) * signOfAMinusB;
		int max = finalSignOperator * a + flip(finalSignOperator) * b;
		return max;
	}

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		int b = -5;

		System.out.println(getMax(a, b));
		System.out.println(getMaxAddressOverflow(a, b));

		/**
		 * 
		 * 
		 * int a = Integer.MAX_VALUE; int b = -5;
		 * 
		 * System.out.println(getMax(a, b));
		 * System.out.println(getMaxAddressOverflow(a, b)); output:
		 * 
		 * -5
		 * 
		 * 2147483647
		 */
	}

}
