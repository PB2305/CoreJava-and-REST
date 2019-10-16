package findCountOfCharacters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCharacterCountTest {
	StringCharacterCount characterCount = new StringCharacterCount();

	@Test
	public void shouldReturnCount() {
		String actual = characterCount.getCharacterCount("iamyashemployee");
		assertEquals("ia2m2y2she3plo", actual);
	}

}
