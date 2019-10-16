package com.yash.springboot.rest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.springboot.rest.controller.EmployeeController;
import com.yash.springboot.rest.model.Employee;
import com.yash.springboot.rest.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	EmployeeService mockEmployeeService;

	@Test
	public void shouldReturnListOfEmployeeInJsonFormat() throws Exception {
		List<Employee> mockEmployees = new ArrayList<Employee>();
		mockEmployees.add(new Employee(1, "ABC", "IT", 50000));
		mockEmployees.add(new Employee(2, "DEF", "Admin", 60000));
		when(mockEmployeeService.getEmployees()).thenReturn(mockEmployees);

		mockMvc.perform(get("/employees")).andExpect(status().isOk());
		verify(mockEmployeeService, times(1)).getEmployees();
	}

	@Test
	public void shouldReturnEmployeeByIdInXmlFormat() throws Exception {
		Optional<Employee> employee = Optional.of(new Employee(1, "ABC", "IT", 50000));
		when(mockEmployeeService.getEmployeeById(1)).thenReturn(employee);

		mockMvc.perform(get("/employees/{id}", 1)).andExpect(status().isOk());
		verify(mockEmployeeService, times(1)).getEmployeeById(1);
	}

	@Test
	public void shouldThrowExceptionOnGetMethodWhenEmployeeDoesNotExist() throws Exception {
		mockMvc.perform(get("/employees/{id}", 100).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
				.andExpect(jsonPath("$.status").value(404));
	}

	@Test
	public void shouldCreateEmployee() throws Exception {
		Employee employee = new Employee(1, "ABC", "IT", 50000);
		when(mockEmployeeService.addNewEmployee(employee)).thenReturn(employee);

		mockMvc.perform(post("/employees").content(new ObjectMapper().writeValueAsString(employee))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
		verify(mockEmployeeService, times(1)).addNewEmployee(employee);
	}

	@Test
	public void shouldUpdateEmployee() throws Exception {
		Employee employee = new Employee(1, "ABC", "IT", 50000);
		when(mockEmployeeService.getEmployeeById(1)).thenReturn(Optional.of(employee));
		when(mockEmployeeService.updateEmployee(employee)).thenReturn(employee);

		mockMvc.perform(put("/employees/{id}", 1).content(new ObjectMapper().writeValueAsString(employee))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
		verify(mockEmployeeService, times(1)).updateEmployee(employee);
	}

	@Test
	public void shouldUpdateEmployeeWithNullValues() throws Exception {
		Employee employee = new Employee(1, "ABC", "IT", 50000);
		Employee updateEmployee = new Employee(1, null, null, 50000);
		when(mockEmployeeService.getEmployeeById(1)).thenReturn(Optional.of(employee));
		when(mockEmployeeService.updateEmployee(updateEmployee)).thenReturn(updateEmployee);

		mockMvc.perform(put("/employees/{id}", 1).content(new ObjectMapper().writeValueAsString(updateEmployee))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(mockEmployeeService, times(1)).updateEmployee(employee);
	}

	@Test
	public void shouldUpdateEmployeeWithEmptyValues() throws Exception {
		Employee employee = new Employee(1, "ABC", "IT", 50000);
		Employee updateEmployee = new Employee(1, "", "", 0);
		when(mockEmployeeService.getEmployeeById(1)).thenReturn(Optional.of(employee));
		when(mockEmployeeService.updateEmployee(updateEmployee)).thenReturn(updateEmployee);

		mockMvc.perform(put("/employees/{id}", 1).content(new ObjectMapper().writeValueAsString(updateEmployee))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(mockEmployeeService, times(1)).updateEmployee(employee);
	}

	@Test
	public void shouldThrowExceptionOnPutMethodWhenEmployeeDoesNotExist() throws Exception {
		Employee employee = new Employee(1, "ABC", "IT", 50000);

		mockMvc.perform(put("/employees/{id}", 100).content(new ObjectMapper().writeValueAsString(employee))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andExpect(jsonPath("$.status").value(404));
	}

	@Test
	public void shouldDeleteEmployeeById() throws Exception {
		Employee employee = new Employee(1, "ABC", "IT", 50000);
		when(mockEmployeeService.getEmployeeById(1)).thenReturn(Optional.of(employee));

		mockMvc.perform(delete("/employees/{id}", 1).content(new ObjectMapper().writeValueAsString(employee)))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldThrowExceptionOnDeleteMethodWhenEmployeeDoesNotExist() throws Exception {
		mockMvc.perform(delete("/employees/{id}", 100).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andExpect(jsonPath("$.status").value(404));
	}

	@Test
	public void shouldDeleteAllEmployee() throws Exception {
		mockMvc.perform(delete("/employees")).andExpect(status().isOk());
	}

	@Test
	public void shouldthrowExceptionIfMethodArgumentIsInvalid() throws Exception {
		mockMvc.perform(delete("/employees/{id}", "abcd")).andExpect(status().isBadRequest());
	}
}
