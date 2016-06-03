package hard;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

	static Map<String, Integer> frequencyMap = new HashMap<>();
	static String book = "This is a book. There are many words in this book, each word has some frequency with it, for example word 'frequency' has frequency of 2";
	static {
		prepareFrequencyMap(book);
	}

	public static int getFrequency(String word) {
		if (!frequencyMap.containsKey(word)) {
			return 0;
		} else {
			return frequencyMap.get(word);
		}
	}

	public static void prepareFrequencyMap(String book) {
		// Regex for whitespace:
		// http://stackoverflow.com/questions/225337/how-do-i-split-a-string-with-any-whitespace-chars-as-delimiters
		String[] words = book.split("\\s+");

		for (String currentWord : words) {
			if (frequencyMap.containsKey(currentWord)) {
				frequencyMap.put(currentWord, frequencyMap.get(currentWord) + 1);
			} else {
				frequencyMap.put(currentWord, 1);
			}
		}
	}

	public static void main(String[] args) {
		String word = "frequency";
		System.out.println(frequencyMap);
		System.out.println(getFrequency(word));

		/**
		 * output:
		 * 
		 * {it,=1, a=1, some=1, in=1, 'frequency'=1, words=1, this=1, for=1,
		 * is=1, many=1, each=1, frequency=2, example=1, with=1, 2=1, There=1,
		 * are=1, of=1, This=1, book,=1, has=2, book.=1, word=2}
		 * 
		 * 2
		 */
	}
}
