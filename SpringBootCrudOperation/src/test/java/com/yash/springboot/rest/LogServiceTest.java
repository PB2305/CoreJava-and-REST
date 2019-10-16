package com.yash.springboot.rest;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.test.context.junit4.SpringRunner;

import com.yash.springboot.rest.dao.EmployeeRepository;
import com.yash.springboot.rest.exception.EmployeeNotFoundException;
import com.yash.springboot.rest.model.Employee;
import com.yash.springboot.rest.service.EmployeeService;
import com.yash.springboot.rest.service.EmployeeServiceImpl;
import com.yash.springboot.rest.service.LogService;

@RunWith(SpringRunner.class)
public class LogServiceTest {
	@Mock
	EmployeeRepository employeeRepository;

	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Test
	public void AOPTest() {
		Employee emp = new Employee(1, "ABC", "IT", 50000);
		when(employeeRepository.findById(1)).thenReturn(Optional.of(emp));

		AspectJProxyFactory proxyFactory = new AspectJProxyFactory(employeeService);
		proxyFactory.addAspect(LogService.class);
		EmployeeService proxy = proxyFactory.getProxy();
		proxy.getEmployeeById(emp.getId());
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void AOPExceptionTest() {
		Employee emp = new Employee(1, "ABC", "IT", 50000);
		when(employeeRepository.findById(1)).thenThrow(EmployeeNotFoundException.class);

		AspectJProxyFactory proxyFactory = new AspectJProxyFactory(employeeService);
		proxyFactory.addAspect(LogService.class);
		EmployeeService proxy = proxyFactory.getProxy();
		proxy.getEmployeeById(emp.getId());
	}

	@Test
	public void pointcutTest() {
		LogService logService = new LogService();
		logService.employeeLogPointcut();
	}
}
