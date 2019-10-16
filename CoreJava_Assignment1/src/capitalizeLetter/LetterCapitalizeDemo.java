package capitalizeLetter;

public class LetterCapitalizeDemo {

	public String capitalizeFirstAndLetter(String input) {
		if (input == null || input == "") {
			throw new RuntimeException("String is null or empty");
		}

		String result = "";
		String[] s = input.split(" ");

		for (String element : s) {
			String updated = element.substring(0, 1).toUpperCase() + element.substring(1, element.length() - 1)
					+ element.substring(element.length() - 1, element.length()).toUpperCase();
			result += updated + " ";
		}
		return result.substring(0, result.length() - 1);
	}
}
