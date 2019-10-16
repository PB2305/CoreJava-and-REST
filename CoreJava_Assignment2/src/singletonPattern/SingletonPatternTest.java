package singletonPattern;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class SingletonPatternTest {
	SingletonPattern obj1;
	SingletonPattern obj2;

	@Test
	public void synchronizedSingletonTest() throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj1 = SingletonPattern.getInstance();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj2 = SingletonPattern.getInstance();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		assertEquals(obj1, obj2);
	}

	@Test
	public void serializationSingletonTest() throws IOException, ClassNotFoundException {
		SingletonPattern instance1 = SingletonPattern.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
		out.writeObject(instance1);
		out.close();

		ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
		SingletonPattern instance2 = (SingletonPattern) in.readObject();
		in.close();

		assertEquals(instance1, instance2);
	}
}
