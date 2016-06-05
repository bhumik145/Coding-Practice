package recursion;

public class CoinsDenominations {

	public static void printCombinations(int finalAmount, int currentDenomination, String equation) {
		if (finalAmount <= 0) {
			System.out.println(equation);
			return;
		} else {
			Integer nextDenom = getNextDenom(currentDenomination);
			if (nextDenom == null) {
				printCombinations(0, finalAmount, equation + currentDenomination + " * " + finalAmount + " + ");
			} else {
				for (int i = 1; finalAmount - (currentDenomination * i) >= 0; i++) {
					int currentAmount = finalAmount - (currentDenomination * i);
					printCombinations(currentAmount, nextDenom, equation + currentDenomination + " * " + i + " + ");
				}
				printCombinations(finalAmount, nextDenom, equation);
			}
		}
	}

	public static Integer getNextDenom(int current) {
		if (current == 25) {
			return 10;
		} else if (current == 10) {
			return 5;
		} else if (current == 5) {
			return 1;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		printCombinations(10, 25, "");
	}
}
