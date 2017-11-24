package com.demo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.config.RedistConfig;
import com.demo.exception.ExceptionResult;
import com.demo.mapper.TestMapper;
import com.demo.plugin.redis.Redis;
import com.demo.plugin.rediscluster.RedisCluster;

@RestController
@RequestMapping("/test")
public class HelloController {
//	@Autowired
//	private RedisCluster redisCluster;
	
	@Autowired
	private Redis redis;
	@Autowired
	private TestMapper mapper;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello world!";
	}

	@RequestMapping("/error")
	public int error() {
		return 100 / 0;
	}

	@RequestMapping("/error2")
	public int error2() throws ExceptionResult {

		if (0 == 0) {
			throw new ExceptionResult(500, "数据异常");
		}
		return 0;
	}

	@RequestMapping("/config")
	public RedistConfig config() {
		RedistConfig redistConfig = new RedistConfig();
		return redistConfig;
	}
	
//	@RequestMapping("/redis")
//	public String redis() {
//		redisCluster.set("a", "a");
//		return redisCluster.get("a").toString();
//	}
	
	@RequestMapping("/redis2")
	public String redis2() {
		redis.setString("b", "bbb");
		return redis.getString("b");
	}
	
	@RequestMapping("/db")
	public List<Map<String, Object>> db() {
		List<Map<String, Object>> queryList = mapper.queryList();
		return queryList;
	}
}
