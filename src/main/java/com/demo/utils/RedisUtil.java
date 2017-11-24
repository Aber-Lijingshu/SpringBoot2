package com.demo.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName: RedisUtil 
 * @Description: redis连接工具类
 * @author shuyu.wang
 * @date 2017年11月23日 下午3:56:05 
 * @version V1.0
 */
public class RedisUtil {
	private static PropertiesRead propertiesRead=new PropertiesRead();

	/**
	 * 非切片链接池
	 */
	private JedisPool jedisPool;

	/**
	 * 非切片连接池初始化
	 */
	private JedisPool initialPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(propertiesRead.getMaxTotal());
		config.setMaxIdle(propertiesRead.getMaxIdle());
		config.setMaxWaitMillis(propertiesRead.getMaxActive());
		config.setTestOnBorrow(propertiesRead.getTestOnBorrow());
		config.setTestOnReturn(propertiesRead.getTestOnReturn());
		jedisPool = new JedisPool(config, propertiesRead.getIp(), propertiesRead.getPort());
		return jedisPool;

	}

	/**
	 * 在多线程环境同步初始化
	 * 
	 */
	private synchronized void poolInit() {

		if (jedisPool == null) {

			initialPool();

		}

	}

	/**
	 * 非切片客户端链接 同步获取非切片Jedis实例
	 * 
	 * @return Jedis
	 * 
	 */
	@SuppressWarnings("deprecation")
	public synchronized Jedis getJedis() {
		if (jedisPool == null) {
			poolInit();
		}
		Jedis jedis = null;
		try {
			if (jedisPool != null) {

				jedis = jedisPool.getResource();
				// jedis.auth(password);
			}

		} catch (Exception e) {
			System.out.println("抛错");
			e.printStackTrace();
			// 释放jedis对象
			jedisPool.returnBrokenResource(jedis);
		} finally {
			// 返还连接池
			if (jedis != null && jedisPool != null) {
				jedisPool.returnResource(jedis);

			}

		}
		return jedis;

	}
	
	
	
	

}
