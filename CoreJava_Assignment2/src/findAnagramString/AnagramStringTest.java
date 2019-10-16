package findAnagramString;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnagramStringTest {
	AnagramString anagramString = new AnagramString();

	@Test(expected = NullPointerException.class)
	public void shouldThrowExceptionIfFirstStringIsNull() {
		anagramString.checkAnagramString(null, "Peek");
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowExceptionIfSecondStringIsNull() {
		anagramString.checkAnagramString("Keep", null);
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowExceptionIfStringsAreNull() {
		anagramString.checkAnagramString(null, null);
	}

	@Test
	public void returnTrueIfTwoStringsAreAnagram() {
		boolean actual = anagramString.checkAnagramString("Keep", "Peek");
		assertTrue(actual);
	}

	@Test
	public void returnFalseIfTwoStringsAreNotAnagram() {
		boolean actual = anagramString.checkAnagramString("Keep", "Kings");
		assertFalse(actual);
	}
}
