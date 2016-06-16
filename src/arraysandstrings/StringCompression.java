package arraysandstrings;

public class StringCompression {

	public static String compressString(String str) {
		int compressedLength = getCompressedLength(str);
		if (compressedLength < str.length()) {
			StringBuffer stringBuffer = new StringBuffer(compressedLength);
			int count = 1;
			char currentChar = str.charAt(0);
			for (int index = 1; index < str.length(); index++) {
				if (currentChar == str.charAt(index)) {
					count++;
				} else {
					stringBuffer.append(currentChar).append(count);
					currentChar = str.charAt(index);
					count = 1;
				}
			}
			stringBuffer.append(currentChar).append(count);
			return stringBuffer.toString();
		} else {
			return str;
		}
	}

	/**
	 * A String should be compressed if the final string results in a string of
	 * less length
	 * 
	 * One simple way to check this condition is to look for three consecutive
	 * characters, i.e, if three characters are compressed in 2 chars, then the
	 * overall string will be of reduced length
	 * 
	 * There is a flaw in the approach mentioned above: if there is a sequence
	 * of 3 consecutive chars, then we save 1 space but we add one space when we
	 * encounter sequence of length 1, hence check the final length
	 * 
	 * @param str
	 * @return
	 */
	public static int getCompressedLength(String str) {
		int count = 1;
		int compressedLength = 0;
		char currentChar = str.charAt(0);

		for (int index = 1; index < str.length(); index++) {
			if (currentChar == str.charAt(index)) {
				count++;
			} else {
				currentChar = str.charAt(index);
				compressedLength = 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		return compressedLength;
	}

	public static void main(String[] args) {
		String str = "aabbbbbbcdddd";
		System.out.println(compressString(str));
	}
}
