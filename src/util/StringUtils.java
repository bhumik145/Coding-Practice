package util;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {

	public static Map<Character, Integer> getFrequencyMap(String string) {
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char currentChar : string.toCharArray()) {
			if (frequencyMap.containsKey(currentChar)) {
				frequencyMap.put(currentChar, frequencyMap.get(currentChar) + 1);
			} else {
				frequencyMap.put(currentChar, 1);
			}
		}
		return frequencyMap;
	}
}
