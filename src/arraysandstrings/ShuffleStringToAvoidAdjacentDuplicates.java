package arraysandstrings;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Given a string e.g. ABCDAABCD. Shuffle he string so that no two smilar
 * letters together. E.g. AABC can be shuffled as ABAC.
 * 
 * https://www.careercup.com/question?id=5739568692199424
 * 
 * 
 * @author bthakkar
 *
 */
public class ShuffleStringToAvoidAdjacentDuplicates {

	public static String shuffleString(String str) {
		Map<Character, Integer> characterToFrequencyMap = new HashMap<>();
		for (char currentChar : str.toCharArray()) {
			if (characterToFrequencyMap.containsKey(currentChar)) {
				characterToFrequencyMap.put(currentChar, characterToFrequencyMap.get(currentChar) + 1);
			} else {
				characterToFrequencyMap.put(currentChar, 1);
			}
		}

		PriorityQueue<Entry<Character, Integer>> priorityQueue = new PriorityQueue<Entry<Character, Integer>>(
				new Comparator<Entry<Character, Integer>>() {
					@Override
					public int compare(Entry<Character, Integer> entry1, Entry<Character, Integer> entry2) {
						return Integer.compare(entry2.getValue(), entry1.getValue());
					}
				});

		for (Entry<Character, Integer> entry : characterToFrequencyMap.entrySet()) {
			priorityQueue.add(entry);
		}

		StringBuffer stringBuffer = new StringBuffer();

		while (priorityQueue.size() > 1) {
			Entry<Character, Integer> firstEntry = priorityQueue.remove();
			Entry<Character, Integer> secondEntry = priorityQueue.remove();
			stringBuffer.append(firstEntry.getKey());
			stringBuffer.append(secondEntry.getKey());
			if (firstEntry.getValue() != 1) {
				firstEntry.setValue(firstEntry.getValue() - 1);
				priorityQueue.add(firstEntry);
			}
			if (secondEntry.getValue() != 1) {
				secondEntry.setValue(secondEntry.getValue() - 1);
				priorityQueue.add(secondEntry);
			}
		}

		if (!priorityQueue.isEmpty()) {
			Entry<Character, Integer> firstEntry = priorityQueue.remove();
			if (firstEntry.getValue() != 1) {
				System.out.println("It's not possible to shuffle such that no two same characters are side by side");
				return null;
			}
		}

		return stringBuffer.toString();
	}

	public static void main(String[] args) {
		String str = "AABCSSSS";

		System.out.println(shuffleString(str));
	}
}
