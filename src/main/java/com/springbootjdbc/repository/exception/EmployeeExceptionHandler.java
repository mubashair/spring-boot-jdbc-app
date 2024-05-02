package com.springbootjdbc.repository.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<EmployeeErrorInfo> handleEmployeeException(Exception ex, WebRequest request) throws Exception {	
		System.out.println("----------------Custom Exception Handler---------------");
		
		EmployeeErrorInfo employeeErrorInfo = new EmployeeErrorInfo(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<EmployeeErrorInfo>(employeeErrorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<EmployeeErrorInfo> handleEmployeeNotFoundException(Exception ex, WebRequest request) throws Exception {	
		System.out.println("----------------Custom Exception Handler---------------");
		
		EmployeeErrorInfo employeeErrorInfo = new EmployeeErrorInfo(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<EmployeeErrorInfo>(employeeErrorInfo, HttpStatus.NOT_FOUND);
	}

}