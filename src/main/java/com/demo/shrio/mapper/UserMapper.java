package com.demo.shrio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.demo.shiro.pojo.User;

@Mapper
public interface UserMapper {
	
	User findByName(@Param("userName") String name);

//	List<User> getList();

}
