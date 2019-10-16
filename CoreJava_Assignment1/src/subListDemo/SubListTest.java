package subListDemo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SubListTest {
	SubList subList = new SubList();

	@Test
	public void shouldReturnSubList() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> actual = subList.getSubList(list, 2, 8);
		assertEquals(list.subList(2, 8), actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowExceptionForInvalidRange() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		subList.getSubList(list, 2, 20);
	}

}
