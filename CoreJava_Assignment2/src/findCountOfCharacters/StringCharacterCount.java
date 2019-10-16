package findCountOfCharacters;

public class StringCharacterCount {

	public String getCharacterCount(String input) {

		String result = "";
		StringBuilder sb = new StringBuilder(input);

		while (sb.length() != 0) {
			int count = 0;
			char ch = sb.charAt(0);
			while (sb.indexOf(ch + "") != -1) {
				sb.deleteCharAt(sb.indexOf(ch + ""));
				count++;
			}

			if (count > 1)
				result = result + ch + count;
			else
				result = result + ch;
		}
		return result;
	}
}
