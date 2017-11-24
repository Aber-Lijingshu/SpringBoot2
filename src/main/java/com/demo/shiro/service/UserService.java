package com.demo.shiro.service;


import com.demo.shiro.pojo.User;

/**
 * @ClassName: UserService 
 * @Description: TODO
 * @author shuyu.wang
 * @date 2017年11月24日 下午5:01:13 
 * @version V1.0
 */
public interface UserService {
	
	User findByName(String userName);

}
