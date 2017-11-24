package com.demo.shiro.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * @ClassName: User 
 * @Description: TODO
 * @author shuyu.wang
 * @date 2017年11月24日 下午4:29:28 
 * @version V1.0
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 499391181074798660L;
	private Integer id;
	private String userName;
	private String password;
	private Set<Role> roles=new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	

}