package doubletonPattern;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DoubletonPatternTest {

	@Test
	public void checkForTwoToneObjectCreation() {

		DoubletonPattern obj1 = DoubletonPattern.getInstance();
		DoubletonPattern obj2 = DoubletonPattern.getInstance();
		DoubletonPattern obj3 = DoubletonPattern.getInstance();
		DoubletonPattern obj4 = DoubletonPattern.getInstance();
		DoubletonPattern obj5 = DoubletonPattern.getInstance();
		DoubletonPattern obj6 = DoubletonPattern.getInstance();

		assertThat(obj3.hashCode(), anyOf(is(obj1.hashCode()), is(obj2.hashCode())));
	}
}
