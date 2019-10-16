package hashmapAscendingSortByValues;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashmapObjectSorting {

	public Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {

		if (map == null)
			throw new RuntimeException("Map is null");

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});

		Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
