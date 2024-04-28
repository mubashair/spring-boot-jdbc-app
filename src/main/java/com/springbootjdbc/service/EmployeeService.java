package com.springbootjdbc.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springbootjdbc.model.EmployeeDto;
@Component
public interface EmployeeService {
	List<EmployeeDto> getAllEmployee();
	EmployeeDto getEmployee(Long id);
	Integer deleteEmployee(Long id);
	int createEmployee(EmployeeDto employee);//inserting record in database
	Integer updateEmployee(EmployeeDto empdto);

}
