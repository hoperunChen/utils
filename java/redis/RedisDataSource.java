package com.longdai.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * redis 数据源接口
 * 
 * @author chenrui
 * @date 2016年9月27日下午4:52:00
 * @version 201609
 */
public interface RedisDataSource {
	
	/**
	 * 获取redias连接
	 * @return
	 * @author chenrui
	 * @date 2016年9月27日 下午4:49:00
	 * @version 201609
	 */
	public abstract ShardedJedis getRedisClient();

	/**
	 * 关闭redis连接
	 * @param shardedJedis
	 * @author chenrui
	 * @date 2016年9月27日 下午4:51:48
	 * @version 201609
	 */
	public void close(ShardedJedis shardedJedis);

}