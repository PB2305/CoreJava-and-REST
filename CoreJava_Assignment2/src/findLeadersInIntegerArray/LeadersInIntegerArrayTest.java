package findLeadersInIntegerArray;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeadersInIntegerArrayTest {

	LeadersInIntegerArray leadersInIntegerArray = new LeadersInIntegerArray();

	@Test
	public void shouldReturnLeadersNumberArray() {
		int[] arr = { 14, 9, 11, 7, 8, 5, 3 };
		int[] expected = { 3, 5, 8, 11, 14, 0, 0 };
		int[] actual = leadersInIntegerArray.getLeaderNumbers(arr);
		assertArrayEquals(expected, actual);
	}
}
