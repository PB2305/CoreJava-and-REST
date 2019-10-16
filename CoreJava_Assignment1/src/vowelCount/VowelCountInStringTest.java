package vowelCount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VowelCountInStringTest {

	VowelCountInString vowelCount = new VowelCountInString();

	@Test(expected = NullPointerException.class)
	public void shouldCheckForNullString() {
		vowelCount.getvowelCount(null);
	}

	@Test
	public void shouldReturnCountOfVowels() {
		int actual = vowelCount.getvowelCount("Wishing you all the best in your future endeavors");
		assertEquals(17, actual);
	}

}
