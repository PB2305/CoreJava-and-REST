package spyNumber;

public class SpyNumberDemo {
	int rem, sum = 0;
	int mul = 1;

	public boolean checkSpyNumber(Integer num) {
		while (num != 0) {
			rem = num % 10;
			sum += rem;
			mul *= rem;
			num /= 10;
		}

		if (sum == mul)
			return true;

		return false;
	}
}
