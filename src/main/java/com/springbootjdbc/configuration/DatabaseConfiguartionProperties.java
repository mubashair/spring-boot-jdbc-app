package com.springbootjdbc.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="spring.datasource")
@Component
public class DatabaseConfiguartionProperties {
	
	private String url;
	private String userName;
	private String password;
	
	public String getUrl() {
		return url;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
