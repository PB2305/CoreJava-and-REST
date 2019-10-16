
package com.yash.design.factory;

import com.yash.design.abstractfactory.ComputerAbstractFactory;
import com.yash.design.model.Computer;

public class ComputerFactory {

	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}
