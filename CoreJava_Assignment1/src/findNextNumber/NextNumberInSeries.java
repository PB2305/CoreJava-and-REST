package findNextNumber;

import java.util.ArrayList;
import java.util.List;

public class NextNumberInSeries {

	public List<Integer> getSeries(List<Integer> list) {
		int diff1 = list.get(1) - list.get(0);
		int diff2 = list.get(2) - list.get(1);
		int lastNum = list.get(list.size() - 1);

		List<Integer> updatedList = new ArrayList<>(list);
		if (list.size() % 2 == 0) {
			updatedList.add(lastNum + diff2);
		} else {
			updatedList.add(lastNum + diff1);
		}
		return updatedList;
	}
}