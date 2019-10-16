package findAnagramString;

import java.util.Arrays;

public class AnagramString {

	public boolean checkAnagramString(String s1, String s2) {
		boolean result = false;
		if (s1 == null || s2 == null)
			throw new NullPointerException();

		if (s1.length() == s2.length()) {
			char[] s1Chars = s1.toLowerCase().toCharArray();
			Arrays.sort(s1Chars);

			char[] s2Chars = s2.toLowerCase().toCharArray();
			Arrays.sort(s2Chars);

			result = Arrays.equals(s1Chars, s2Chars);
		}
		return result;
	}
}
