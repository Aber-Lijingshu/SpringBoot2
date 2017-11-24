package com.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.ExceptionResult;
import com.demo.mapper.TestMapper;
import com.demo.plugin.redis.Redis;

@RestController
@RequestMapping("/test")
public class HelloController {
	// @Autowired
	// private RedisCluster redisCluster;

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
	// @RequestMapping("/redis")
	// public String redis() {
	// redisCluster.set("a", "a");
	// return redisCluster.get("a").toString();
	// }

	@RequestMapping("/redis2")
	public String redis2() {
		System.out.println("redis=======" + redis);
		redis.setString("b", "bbb");
		return redis.getString("b");
	}

	@RequestMapping("/db")
	public List<Map<String, Object>> db() {
		List<Map<String, Object>> queryList = mapper.queryList();
		return queryList;
	}

	// 分布式session测试

	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public Map<String, Object> firstResp(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		request.getSession().setAttribute("request Url", request.getRequestURL());
		map.put("request Url", request.getRequestURL());
		return map;
	}

	@RequestMapping(value = "/sessions", method = RequestMethod.GET)
	public Object sessions(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("sessionId", request.getSession().getId());
		map.put("message", request.getSession().getAttribute("request Url"));
		return map;
	}
}
