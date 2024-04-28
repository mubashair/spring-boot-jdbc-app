package com.springbootjdbc.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbootjdbc.model.EmployeeDto;
import com.springbootjdbc.repository.exception.EmployeeNotFoundException;

@Repository
public class EmployeeRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static 	String SELECT_QUERY="SELECT * FROM EMPLOYEE";
	private static String INSERT_QUERY="INSERT INTO EMPLOYEE(ID, FIRSTNAME, LASTNAME, MOBILENUMBER, AGE, CITY)"
			+ "VALUES(?, ?, ?, ?, ?, ?)";
	private static String FIND_QUERY="SELECT * FROM EMPLOYEE WHERE ID=?";
	
	private static String UPDATE_QUERY = "UPDATE EMPLOYEE SET FIRSTNAME=?, LASTNAME=?, MOBILENUMBER=?, "
			+ "AGE=?, CITY=? WHERE ID=?";
	
	private static String DELETE_QUERY="DELETE FROM EMPLOYEE WHERE ID=?";
	//getting all the employees data
	public List<EmployeeDto> findAllEmployees(){
		return jdbcTemplate.query(SELECT_QUERY, new BeanPropertyRowMapper<>(EmployeeDto.class));
	}
	//inserting a new record in database
	public int createEmployee(EmployeeDto employee) {
		return jdbcTemplate.update(INSERT_QUERY, employee.getId(), employee.getFirstName(),
				employee.getLastName(), employee.getMobileNumber(), employee.getAge(), employee.getCity());
	}
	//Getting a specific employee based on id
	public EmployeeDto findEmployeeById(Long id) {
		EmployeeDto employeeDto;
		try {
			employeeDto = jdbcTemplate.queryForObject(FIND_QUERY, new BeanPropertyRowMapper<>(EmployeeDto.class), id);
		}catch(EmptyResultDataAccessException e) {
			throw new EmployeeNotFoundException("id="+id);
		}
		return employeeDto;
	}
	//updating the record of an employee
	public Integer updateEmployee(EmployeeDto employee) {
		return jdbcTemplate.update(UPDATE_QUERY, employee.getFirstName(), employee.getLastName(), employee.getMobileNumber(), employee.getAge(), employee.getCity(), employee.getId());
	}
	//deleting the record of an  employee
	public Integer deleteEmployee(Long id) {
		return jdbcTemplate.update(DELETE_QUERY, id);
	}
	

}
