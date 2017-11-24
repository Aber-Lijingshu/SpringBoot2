package com.demo.shiro.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Permission 
 * @Description: 权限
 * @author shuyu.wang
 * @date 2017年11月24日 下午4:36:44 
 * @version V1.0
 */
public class Permission {
	private Integer id;
	private String permissionName;
	private Set<Role> roles=new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	

}
