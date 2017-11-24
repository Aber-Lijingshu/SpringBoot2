package com.demo.plugin.rediscluster;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

/**
 * @ClassName: RedisClusterImpl 
 * @Description: redis集群实现类
 * @author shuyu.wang
 * @date 2017年11月23日 下午3:55:09 
 * @version V1.0
 */
//@Service
public class RedisClusterImpl implements RedisCluster{
	
	private JedisCluster jedisCluster;
	@Autowired
	public RedisClusterImpl(JedisClusterFactory jedisClusterFactory){
	       jedisCluster=jedisClusterFactory.getJedisCluster();
	}

	@Override
	public Object get(String key){
	    return jedisCluster.get(key);        
	}

	@Override
	public Object[] gets(String[] keys) {
	    return null;
	}

	@Override
	public void set(String key, Object obj) {
	    jedisCluster.set(key, obj.toString());
	}

	@Override
	public void delete(String key) {
	    jedisCluster.del(key);
	}

}
