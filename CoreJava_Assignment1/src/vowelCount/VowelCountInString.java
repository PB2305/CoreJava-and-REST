package vowelCount;

public class VowelCountInString {

	public Integer getvowelCount(String input) {
		Integer count = 0;
		if (input == null)
			throw new NullPointerException("String is null");
		else {
			for (char c : input.toCharArray())
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					count++;
		}
		return count;

	}

}
