package findNextNumber;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NextNumberInSeriesTest {

	NextNumberInSeries series = new NextNumberInSeries();

	@Test
	public void shouldReturnSeriesIncludingNextNumberAtEvenIndex() {
		List<Integer> list = Arrays.asList(7, 10, 8, 11, 9, 12);
		List<Integer> expected = Arrays.asList(7, 10, 8, 11, 9, 12, 10);
		List<Integer> actual = series.getSeries(list);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnSeriesIncludingNextNumberAtOddIndex() {
		List<Integer> list = Arrays.asList(7, 10, 8, 11, 9, 12, 10);
		List<Integer> expected = Arrays.asList(7, 10, 8, 11, 9, 12, 10, 13);
		List<Integer> actual = series.getSeries(list);
		System.out.println(actual);
		assertEquals(expected, actual);
	}
}
