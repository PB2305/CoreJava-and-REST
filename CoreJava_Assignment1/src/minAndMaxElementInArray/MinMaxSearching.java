package minAndMaxElementInArray;

import java.util.Arrays;

public class MinMaxSearching {

	public int[] getMinAndMaxElementInArray(int[] arr) {

		int[] result = new int[2];
		if (arr != null && arr.length != 0) {
			Arrays.sort(arr);
			result[0] = arr[0];
			result[1] = arr[arr.length - 1];
		} else
			throw new RuntimeException("Array is null or empty");

		return result;
	}
}
