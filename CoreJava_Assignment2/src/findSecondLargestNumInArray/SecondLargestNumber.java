package findSecondLargestNumInArray;

import java.util.Arrays;

public class SecondLargestNumber {

	public int getSecondLargestNumber(int[] input) {
		if (input.length < 2) {
			throw new RuntimeException("Array is null or contains less than 2 elements");
		}
		Arrays.sort(input);
		return input[input.length - 2];
	}
}
