package com.demo.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shiro.pojo.User;
import com.demo.shiro.service.UserService;
import com.demo.shrio.mapper.UserMapper;

/**
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author shuyu.wang
 * @date 2017年11月24日 下午5:02:34 
 * @version V1.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByName(String userName) {
		return userMapper.findByName(userName);
	}

}
