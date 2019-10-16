package sumOfEvenNumbers;

import java.util.Arrays;

public class SumOfEvenNumInArray {

	public int getSum(Integer[] arr) {
		return Arrays.asList(arr).stream().filter(i -> (i % 2 == 0)).mapToInt(Integer::intValue).sum();
	}
}
