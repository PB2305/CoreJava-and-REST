package com.yash.springboot.rest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
public class EmployeeServiceTest {

	@Mock
	EmployeeRepository employeeRepository;

	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Test
	public void ShouldReturnEmployeeList() {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "ABC", "IT", 50000));
		when(employeeRepository.findAll()).thenReturn(empList);
		employeeService.getEmployees();
		verify(employeeRepository).findAll();
	}

	@Test
	public void ShouldReturnEmployeeById() {
		Optional<Employee> emp = Optional.of(new Employee(1, "ABC", "IT", 50000));
		when(employeeRepository.findById(1)).thenReturn(emp);
		employeeService.getEmployeeById(1);
		verify(employeeRepository).findById(1);
	}

	@Test
	public void ShouldCreateEmployee() {
		Employee emp = new Employee(1, "ABC", "IT", 50000);
		when(employeeRepository.save(emp)).thenReturn(emp);
		employeeService.addNewEmployee(emp);
		verify(employeeRepository).save(emp);
	}

	@Test
	public void ShouldUpdateEmployee() {
		Employee emp = new Employee(1, "ABC", "IT", 50000);
		when(employeeRepository.save(emp)).thenReturn(emp);
		employeeService.updateEmployee(emp);
		verify(employeeRepository).save(emp);
	}

	@Test
	public void ShouldDeleteEmployeeById() {
		doNothing().when(employeeRepository).deleteById(1);
		employeeService.deleteEmployeeById(1);
		verify(employeeRepository).deleteById(1);
	}

	@Test
	public void ShouldDeleteAllEmployee() {
		doNothing().when(employeeRepository).deleteAll();
		employeeService.deleteAllEmployees();
		verify(employeeRepository).deleteAll();
	}
}
