package com.demo.shiro.pojo;

import java.util.HashSet;
import java.util.Set;



/**
 * @ClassName: Role 
 * @Description: 角色
 * @author shuyu.wang
 * @date 2017年11月24日 下午4:33:24 
 * @version V1.0
 */
public class Role {
	private Integer id;
	private String roleName;
	private Set<Permission> permissions=new HashSet<>();
	private Set<User> users=new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	} 


}
