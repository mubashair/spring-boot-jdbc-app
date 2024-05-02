package com.springbootjdbc.repository.exception;

import java.time.LocalDateTime;

public class EmployeeErrorInfo {
	private LocalDateTime localDateTime;
	private String meesage;
	private String description;
	public EmployeeErrorInfo(LocalDateTime localDateTime, String meesage, String description) {
		this.localDateTime = localDateTime;
		this.meesage = meesage;
		this.description = description;
	}
	
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public String getMeesage() {
		return meesage;
	}
	public String getDescription() {
		return description;
	}
	
}
