package immutableClass;

public class ImmutableClass {

	private int val;

	private ImmutableClass(int v) {
		this.val = v;
	}

	public static ImmutableClass getInstance(int val) {
		return new ImmutableClass(val);
	}

	public int getVal() {
		return this.val;
	}
}