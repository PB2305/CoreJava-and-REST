package replaceNumberInArrrayList;

import java.util.Collections;
import java.util.List;

public class ReplaceNumberDemo {

	public List<Integer> replaceNumber(List<Integer> list, Integer toReplace, Integer replacedWith) {
		if (toReplace != null && replacedWith != null) {
			if (list.contains(toReplace))
				Collections.replaceAll(list, toReplace, replacedWith);
		} else
			throw new RuntimeException("Number is null");
		return list;
	}
}