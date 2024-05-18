package com.springbootjdbc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBConfigurationController {
	@Autowired
	private DatabaseConfiguartionProperties databaseConfiguartionProperties;
	@GetMapping("databaseproperties")
	public DatabaseConfiguartionProperties DBInfo() {
		return databaseConfiguartionProperties;
	}

}
