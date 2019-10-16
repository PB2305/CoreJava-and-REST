package findLeadersInIntegerArray;

public class LeadersInIntegerArray {

	public int[] getLeaderNumbers(int[] arr) {

		int count = 0;
		int[] result = new int[arr.length];

		result[count++] = arr[arr.length - 1];
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				result[count++] = arr[i - 1];
			}
		}
		return result;
	}
}
