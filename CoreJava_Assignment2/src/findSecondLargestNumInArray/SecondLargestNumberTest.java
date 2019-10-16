package findSecondLargestNumInArray;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SecondLargestNumberTest {

	SecondLargestNumber largestNumber = new SecondLargestNumber();

	@Test
	public void shouldReturnSecondLargestNumber() {
		int[] input = { 12, 3, 43, 42, 2, 2 };
		int result = largestNumber.getSecondLargestNumber(input);
		assertEquals(42, result);
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionIfArrayIsNull() {
		int[] input = {};
		largestNumber.getSecondLargestNumber(input);
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionIfArrayContainsLessThanTwoElements() {
		int[] input = { 12 };
		largestNumber.getSecondLargestNumber(input);
	}
}
