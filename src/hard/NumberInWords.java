package hard;

import java.util.HashMap;
import java.util.Map;

public class NumberInWords {

	public static Map<Integer, String> chunkToWordPresentation;

	static {
		chunkToWordPresentation = new HashMap<>();
		chunkToWordPresentation.put(0, "");
		chunkToWordPresentation.put(1, "Thousand");
		chunkToWordPresentation.put(2, "Million");
		chunkToWordPresentation.put(3, "Billion");
	}

	public static void printThreeDigitWord(int number) {
		if (number < 20) {
			System.out.print(getWordsForNumberLessThanTwenty(number) + " ");
		} else if (number < 99) {
			System.out.print(getWordsPresentationForTens(number - (number % 10)) + " ");
			printThreeDigitWord(number % 10);
		} else {
			int firstDigit = number / 100;
			System.out.print(getWordsForNumberLessThanTwenty(firstDigit) + " Hundred ");
			printThreeDigitWord(number % 100);
		}
	}

	public static void printNumberInWords(int number) {
		String numberInString = "" + number;
		int chunk = 0;
		int count = 0;
		int index = numberInString.length() - 1;
		StringBuffer currentChunk = new StringBuffer();
		do {
			count++;
			currentChunk.append(numberInString.charAt(index));
			if (count % 3 == 0 || index == 0) {
				printThreeDigitWord(Integer.parseInt(currentChunk.reverse().toString()));
				System.out.println(chunkToWordPresentation.get(chunk));
				chunk++;
				currentChunk = new StringBuffer();
			}
			index--;
		} while (index >= 0);

	}

	public static String getWordsForNumberLessThanTwenty(int number) {
		String wordRepresentationOfNumber = "";
		switch (number) {
		case 1:
			wordRepresentationOfNumber = "One";
			break;
		case 2:
			wordRepresentationOfNumber = "Two";
			break;
		case 3:
			wordRepresentationOfNumber = "Three";
			break;
		case 4:
			wordRepresentationOfNumber = "Four";
			break;
		case 5:
			wordRepresentationOfNumber = "Five";
			break;
		case 6:
			wordRepresentationOfNumber = "Six";
			break;
		case 7:
			wordRepresentationOfNumber = "Seven";
			break;
		case 8:
			wordRepresentationOfNumber = "Eight";
			break;
		case 9:
			wordRepresentationOfNumber = "Nine";
			break;
		case 10:
			wordRepresentationOfNumber = "Ten";
			break;
		case 11:
			wordRepresentationOfNumber = "Eleven";
			break;
		case 12:
			wordRepresentationOfNumber = "Twelve";
			break;
		case 13:
			wordRepresentationOfNumber = "Thirteen";
			break;
		case 14:
			wordRepresentationOfNumber = "Fourteen";
			break;
		case 15:
			wordRepresentationOfNumber = "Fifteen";
			break;
		case 16:
			wordRepresentationOfNumber = "Sixteen";
			break;
		case 17:
			wordRepresentationOfNumber = "Seventeen";
			break;
		case 18:
			wordRepresentationOfNumber = "Eighteen";
			break;
		case 19:
			wordRepresentationOfNumber = "Ninteen";
			break;
		}
		return wordRepresentationOfNumber;
	}

	public static String getWordsPresentationForTens(int number) {
		String wordPresentationForTens = "";
		switch (number) {
		case 20:
			wordPresentationForTens = "Twenty";
			break;
		case 30:
			wordPresentationForTens = "Thirty";
			break;
		case 40:
			wordPresentationForTens = "Fourty";
			break;
		case 50:
			wordPresentationForTens = "Fifty";
			break;
		case 60:
			wordPresentationForTens = "Sixty";
			break;
		case 70:
			wordPresentationForTens = "Seventy";
			break;
		case 80:
			wordPresentationForTens = "Eighty";
			break;
		case 90:
			wordPresentationForTens = "Ninty";
			break;
		}
		return wordPresentationForTens;
	}

	public static void main(String[] args) {
		printNumberInWords(1245635444);

		/**
		 * 
		 * Input: 1245635444
		 * 
		 * Output:
		 * 
		 * Four Hundred Fourty Four
		 * 
		 * Six Hundred Thirty Five Thousand
		 * 
		 * Two Hundred Fourty Five Million
		 * 
		 * One Billion
		 */
	}
}
