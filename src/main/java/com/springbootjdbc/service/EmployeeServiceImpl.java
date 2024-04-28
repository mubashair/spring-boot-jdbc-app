package com.springbootjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbootjdbc.model.EmployeeDto;
import com.springbootjdbc.repository.EmployeeRepository;
@Component
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAllEmployees();
	}

	@Override
	public EmployeeDto getEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeeById(id);
	}
	@Override
	public int createEmployee(EmployeeDto emplpoyee) {
		
		return employeeRepository.createEmployee(emplpoyee);
	}

	@Override
	public Integer updateEmployee(EmployeeDto empdto) {
		return employeeRepository.updateEmployee(empdto);
		
	}

	@Override
	public Integer deleteEmployee(Long id) {
		employeeRepository.deleteEmployee(id);
		return null;
	}

}
