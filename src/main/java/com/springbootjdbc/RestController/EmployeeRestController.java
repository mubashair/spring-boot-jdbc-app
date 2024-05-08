package com.springbootjdbc.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjdbc.model.EmployeeDto;
import com.springbootjdbc.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/findAllEmployees")
	public List<EmployeeDto> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	@PostMapping("/createEmployee")
	public int createEmployee(@Valid @RequestBody EmployeeDto employee) {
		return employeeService.createEmployee(employee);
	}
	@GetMapping("findEmployee/{id}")
	EmployeeDto findEmployee(@PathVariable Long id) {
		return employeeService.getEmployee(id); 
	}
	@PostMapping("findEmployee")
	EmployeeDto findEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.getEmployee(employeeDto.getId());
	}
	@PutMapping("updateEmployee")
	Integer updateEmployee(@RequestBody EmployeeDto empDto) {
		return employeeService.updateEmployee(empDto);
	}
	@DeleteMapping("deleteEmployee/{id}")
	Integer deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
}
