package addDayToCurrentDate;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class CalendarTest {
	CalendarDemo calendarDemo = new CalendarDemo();

	@Test
	public void shouldAddDaysInCurrentDate() {
		LocalDate expected = LocalDate.now().plusDays(5);
		LocalDate actual = calendarDemo.addDaysToCurrentDate(5);

		assertEquals(expected, actual);
	}
}
