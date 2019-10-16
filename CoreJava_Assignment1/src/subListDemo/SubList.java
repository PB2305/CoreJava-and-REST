package subListDemo;

import java.util.List;

public class SubList {

	public List<Integer> getSubList(List<Integer> list, int fromIndex, int toIndex) {
		list = list.subList(fromIndex, toIndex);
		return list;
	}

}
