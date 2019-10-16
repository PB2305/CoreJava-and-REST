package minAndMaxElementInArray;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MinMaxSearchingTest {
	MinMaxSearching minMaxSearching = new MinMaxSearching();

	@Test(expected = RuntimeException.class)
	public void shouldCheckIfArrayIsNull() {
		int[] arr = null;
		minMaxSearching.getMinAndMaxElementInArray(arr);
	}

	@Test(expected = RuntimeException.class)
	public void shouldCheckIfArrayIsEmpty() {
		int[] arr = new int[0];
		minMaxSearching.getMinAndMaxElementInArray(arr);
	}

	@Test
	public void shouldReturnArrayContaningMinAndMaxElements() {
		int[] arr = { 4, 7, 1, 9, 20, 6, 9, 2 };
		int[] actual = minMaxSearching.getMinAndMaxElementInArray(arr);
		int[] expected = { 1, 20 };
		assertArrayEquals(expected, actual);
	}
}
