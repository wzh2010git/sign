package com.wuzhou.util;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

import java.util.ArrayList;
import java.util.List;

public class RedisShardedPool {

    private static ShardedJedisPool pool = null;
    public static void initPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMinIdle(2);
        config.setMaxTotal(20);

        JedisShardInfo info1 = new JedisShardInfo("192.168.1.106", 6379,10);
        List<JedisShardInfo> list = new ArrayList<>(1);
        list.add(info1);
        pool = new ShardedJedisPool(config, list, Hashing.MURMUR_HASH, Sharded.DEFAULT_KEY_TAG_PATTERN);
    }

    public static ShardedJedisPool getPool() {
        return pool;
    }

    public static void main(String[] args){
        RedisShardedPool.initPool();
        pool.getResource().set("test","success");
    }
}
