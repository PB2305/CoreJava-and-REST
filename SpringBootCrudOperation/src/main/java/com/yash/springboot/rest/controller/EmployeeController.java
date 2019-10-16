package com.yash.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.springboot.rest.exception.EmployeeNotFoundException;
import com.yash.springboot.rest.model.Employee;
import com.yash.springboot.rest.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Employee Entity!!!!")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@ApiOperation(value = "Get List of Employees in the System ", response = Employee.class, tags = "Get All Employees")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 404, message = "Not Found!!!") })
	@RequestMapping(method = RequestMethod.GET, produces = { "application/xml", "application/json" })
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@ApiOperation(value = "Get Employee By Id in the System ", response = Employee.class, tags = "Get Employee By Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 404, message = "Not Found!!!") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/xml", "application/json" })
	public Resource<Employee> getEmployeeById(@PathVariable int id) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);
		Resource<Employee> resource;
		if (emp.isPresent()) {
			resource = new Resource<Employee>(emp.get());

			Link selflink = ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class).getEmployees()).withSelfRel();
			resource.add(selflink);
		} else
			throw new EmployeeNotFoundException("Could not find employee with id- " + id);
		return resource;

	}

	@ApiOperation(value = "Add new Employee in the System ", response = Employee.class, tags = "Add Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 404, message = "Not Found!!!") })
	@RequestMapping(method = RequestMethod.POST, consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public Employee createEmployee(@RequestBody Employee newemp) {
		return employeeService.addNewEmployee(newemp);
	}

	@ApiOperation(value = "Update Employee in the System ", response = Employee.class, tags = "Update Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 404, message = "Not Found!!!") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/xml",
			"application/json" }, produces = { "application/xml", "application/json" })
	public Employee updateEmployee(@RequestBody Employee updemp, @PathVariable int id) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);
		if (!emp.isPresent())
			throw new EmployeeNotFoundException("Could not find employee with id - " + id);

		if (updemp.getName() == null || updemp.getName().isEmpty())
			updemp.setName(emp.get().getName());
		if (updemp.getDepartment() == null || updemp.getDepartment().isEmpty())
			updemp.setDepartment(emp.get().getDepartment());
		if (updemp.getSalary() == 0)
			updemp.setSalary(emp.get().getSalary());

		updemp.setId(id);
		return employeeService.updateEmployee(updemp);
	}

	@ApiOperation(value = "Delete Employee By Id in the System ", response = Employee.class, tags = "Delete Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 404, message = "Not Found!!!") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEmployeeById(@PathVariable int id) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);
		if (!emp.isPresent())
			throw new EmployeeNotFoundException("Could not find employee with id - " + id);

		employeeService.deleteEmployeeById(id);
	}

	@ApiOperation(value = "Delete All Employees in the System ", response = Employee.class, tags = "Delete All Employees")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 404, message = "Not Found!!!") })
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAll() {
		employeeService.deleteAllEmployees();
	}
}
