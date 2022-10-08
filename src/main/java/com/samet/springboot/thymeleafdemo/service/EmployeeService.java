package com.samet.springboot.thymeleafdemo.service;

import java.util.List;

import com.samet.springboot.thymeleafdemo.entity.Employee;



public interface EmployeeService {  // EmployeeService interface
	
	public List<Employee> findAll();
	public Employee getById(int employeeId);
	public void deleteById(int employeeId);
	public void save(Employee employee);

}
