package doubletonPattern;

public class DoubletonPattern {

	private static DoubletonPattern pattern1;
	private static DoubletonPattern pattern2;

	private DoubletonPattern() {
	}

	public static DoubletonPattern getInstance() {
		if (pattern1 == null) {
			pattern1 = new DoubletonPattern();
			return pattern1;
		} else if (pattern2 == null) {
			pattern2 = new DoubletonPattern();
			return pattern2;
		} else {
			if (Math.random() > 0.5) {
				return pattern1;
			} else {
				return pattern2;
			}
		}

	}
}
