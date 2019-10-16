package sumOfEvenNumbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumOfEvenNumInArrayTest {
	SumOfEvenNumInArray sumNumInArray = new SumOfEvenNumInArray();

	@Test
	public void shouldReturnSumOfEvenNumbers() {
		Integer[] arr = { 12, 3, 45, 65, 8, 9, 10, 4, 6 };
		int actual = sumNumInArray.getSum(arr);
		assertEquals(40, actual);
	}
}
