package spyNumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SpyNumberTest {
	SpyNumberDemo spy = new SpyNumberDemo();

	@Test
	public void shouldReturnTrueIfNumberIsSpy() {
		Boolean check = spy.checkSpyNumber(123);
		assertTrue(check);
	}

	@Test
	public void shouldReturnFalseIfNumberIsSpy() {
		Boolean falseCheck = spy.checkSpyNumber(125);
		assertFalse(falseCheck);
	}

}
