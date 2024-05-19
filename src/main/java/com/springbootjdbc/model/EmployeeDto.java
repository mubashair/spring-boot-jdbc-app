package com.springbootjdbc.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {
	@NotNull
	private Long id;
	@NotEmpty(message="First name cannot be empty")
	private String firstName;
	@NotEmpty(message="Last name cannot be empty")
	private String lastName;
	@NotNull(message="Mobile number cannot be empty")
	private Long mobileNumber;
	@NotNull(message="Age cannot be empty")
	private Integer age;
	@NotEmpty(message="City name cannot be empty")
	private String city;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}

