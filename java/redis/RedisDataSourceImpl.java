package com.longdai.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


/**
 * redis连接管理类
 * 
 * @author chenrui
 * @date 2016年9月27日下午4:48:16
 * @version 201609
 */
public class RedisDataSourceImpl implements RedisDataSource {

	private static Log log = LogFactory.getLog(RedisDataSourceImpl.class);
	
	private ShardedJedisPool shardedJedisPool;

	public ShardedJedisPool getShardedJedisPool() {
		return shardedJedisPool;
	}

	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}
	

	@Override
	public ShardedJedis getRedisClient() {
		try {
			ShardedJedis shardJedis = shardedJedisPool.getResource();
			return shardJedis;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("getRedisClent error", e);
		}
		return null;
	}

	@Override
	public void close(ShardedJedis shardedJedis) {
		shardedJedis.close();
	}


}
