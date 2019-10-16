package findWrongNumber;

import java.util.List;

public class WrongNumberInSeries {

	public int getWrongNumber(List<Integer> list) {
		int wrongNumber = 0;
		for (int i = 0; i < list.size()-2; i++) {
			if (i % 2 == 0) {
				if ((list.get(i + 2) - list.get(i)) != 5) {
					wrongNumber = list.get(i+2);
					break;
				}
			} else {
				if ((list.get(i + 2) - list.get(i)) != 10) {
					wrongNumber = list.get(i+2);
					break;
				}
			}
		}
		return wrongNumber;
	}
}
