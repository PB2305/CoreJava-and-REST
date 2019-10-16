package findWrongNumber;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WrongNumberInSeriesTest {

	WrongNumberInSeries series = new WrongNumberInSeries();

	@Test
	public void shouldReturnWrongNumberInseries() {
		List<Integer> list = Arrays.asList(3, 12, 8, 19, 13, 32, 18, 42, 23, 52);
		int actual = series.getWrongNumber(list);
		assertEquals(19, actual);

		list = Arrays.asList(3, 12, 8, 22, 13, 32, 20, 42, 23, 52);
		actual = series.getWrongNumber(list);
		assertEquals(20, actual);
	}

	@Test
	public void shouldReturnZeroIfNoWrongNumberFound() {
		List<Integer> list = Arrays.asList(3, 12, 8, 22, 13, 32, 18, 42, 23, 52);
		int actual = series.getWrongNumber(list);
		assertEquals(0, actual);
	}
}
