package com.study.spring.properties;

public class JDBCBeanTest {
	public String username;
	public String password;
	public String url;
	public String driver;
	public String initialSize;
	public String maxActive;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}
	public String getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}
	@Override
	public String toString() {
		return "JDBCBean [username=" + username + ", password=" + password + ", url=" + url + ", driver=" + driver
				+ ", initialSize=" + initialSize + ", maxActive=" + maxActive + "]";
	}
	
}
