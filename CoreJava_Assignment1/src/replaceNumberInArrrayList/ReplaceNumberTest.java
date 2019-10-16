package replaceNumberInArrrayList;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ReplaceNumberTest {

	List<Integer> list;
	ReplaceNumberDemo replaceNum = new ReplaceNumberDemo();

	@Before
	public void setUp() {
		list = Arrays.asList(55, 25, 368);
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionIfToReplaceNumberIsNull() {
		replaceNum.replaceNumber(list, null, null);
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionIfReplacedWithNumberIsNull() {
		replaceNum.replaceNumber(list, 25, null);
	}

	@Test
	public void shouldCheckIfNumberIsPresentInArrayList() {
		replaceNum.replaceNumber(list, 25, 6);
	}

	@Test
	public void shouldCheckIfNumberIsNotPresentInArrayList() {
		replaceNum.replaceNumber(list, 100, 6);
	}

	@Test
	public void shouldReturnUpdatedArrayList() {
		List<Integer> actual = replaceNum.replaceNumber(list, 25, 6);
		List<Integer> expected = Arrays.asList(55, 6, 368);
		assertEquals(expected, actual);
	}
}
