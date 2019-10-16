package com.yash.springboot.rest;

import org.junit.Test;

import com.yash.springboot.rest.model.Employee;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class EmployeeTest {

	@Test
	public void equalsAndHashCodeTest() {
		EqualsVerifier.forClass(Employee.class).suppress(Warning.NONFINAL_FIELDS).usingGetClass().verify();
	}
}
