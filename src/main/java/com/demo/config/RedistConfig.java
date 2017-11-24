package com.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "redis")
@PropertySource("classpath:redis.properties")
public class RedistConfig {
	
	private String ip;
//	private String port;
//	private String password;
//	private String maxActive;
//	private String maxIdle;
//	private String maxWait;
//	private String testOnBorrow;
//	private String testOnReturn;
//	private String expire;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
//	public String getPort() {
//		return port;
//	}
//	public void setPort(String port) {
//		this.port = port;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getMaxActive() {
//		return maxActive;
//	}
//	public void setMaxActive(String maxActive) {
//		this.maxActive = maxActive;
//	}
//	public String getMaxIdle() {
//		return maxIdle;
//	}
//	public void setMaxIdle(String maxIdle) {
//		this.maxIdle = maxIdle;
//	}
//	public String getMaxWait() {
//		return maxWait;
//	}
//	public void setMaxWait(String maxWait) {
//		this.maxWait = maxWait;
//	}
//	public String getTestOnBorrow() {
//		return testOnBorrow;
//	}
//	public void setTestOnBorrow(String testOnBorrow) {
//		this.testOnBorrow = testOnBorrow;
//	}
//	public String getTestOnReturn() {
//		return testOnReturn;
//	}
//	public void setTestOnReturn(String testOnReturn) {
//		this.testOnReturn = testOnReturn;
//	}
//	public String getExpire() {
//		return expire;
//	}
//	public void setExpire(String expire) {
//		this.expire = expire;
//	}
//	
	

}
