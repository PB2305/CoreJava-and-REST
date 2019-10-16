package capitalizeLetter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LetterCapitalizeTest {
	LetterCapitalizeDemo capital = new LetterCapitalizeDemo();

	@Test(expected = RuntimeException.class)
	public void shouldCheckEmptyString() {
		capital.capitalizeFirstAndLetter("");
	}

	@Test(expected = RuntimeException.class)
	public void shouldCheckNullString() {
		capital.capitalizeFirstAndLetter(null);
	}

	@Test
	public void shouldCapitalizeTheFirstAndLastLetterInString() {
		String actual = capital.capitalizeFirstAndLetter("yash pune office");
		assertEquals("YasH PunE OfficE", actual);
	}
}
