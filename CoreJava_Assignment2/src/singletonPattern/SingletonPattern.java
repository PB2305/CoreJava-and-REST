package singletonPattern;

import java.io.Serializable;

public class SingletonPattern implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SingletonPattern instance;

	private SingletonPattern() {
	}

	public static SingletonPattern getInstance() {
		if (instance == null) {
			synchronized (SingletonPattern.class) {
				if (instance == null) {
					instance = new SingletonPattern();
				}
			}
		}
		return instance;
	}

	protected Object readResolve() {
		return instance;
	}
}
