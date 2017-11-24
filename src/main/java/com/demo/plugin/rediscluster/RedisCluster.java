package com.demo.plugin.rediscluster;

/**
 * @ClassName: RedisCluster 
 * @Description: redis集群实现接口
 * @author shuyu.wang
 * @date 2017年11月23日 下午3:55:23 
 * @version V1.0
 */
public interface RedisCluster {
	public Object get(String key);

	public Object[] gets(String[] keys);

	public void set(String key, Object obj);

	public void delete(String key);

}
