package addDayToCurrentDate;

import java.time.LocalDate;

public class CalendarDemo {

	public LocalDate addDaysToCurrentDate(Integer days) {

		LocalDate date = LocalDate.now();
		date = date.plusDays(days);
		return date;
	}
}
