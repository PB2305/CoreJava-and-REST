package hashmapAscendingSortByValues;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class HashmapObjectSortingTest {

	HashmapObjectSorting hashmapObjectSorting = new HashmapObjectSorting();

	@Test
	public void shouldReturnSortedHashmap() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(6, 60);
		map.put(3, 30);
		map.put(5, 50);
		map.put(8, 10);
		map.put(4, 20);

		Map<Integer, Integer> expected = new LinkedHashMap<>();
		expected.put(8, 10);
		expected.put(4, 20);
		expected.put(3, 30);
		expected.put(5, 50);
		expected.put(6, 60);
		Map<Integer, Integer> actual = hashmapObjectSorting.sortByValue(map);
		assertEquals(expected.toString(), actual.toString());
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionIfMapIsNull() {
		Map<Integer, Integer> map = null;
		hashmapObjectSorting.sortByValue(map);
	}
}
