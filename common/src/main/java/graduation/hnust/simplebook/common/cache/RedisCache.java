/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.common.cache;

import io.terminus.common.redis.utils.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;

/**
 * Redis 缓存, 暂时用于缓存手机验证码
 *
 * Author  : panxin
 * Date    : 8:01 PM 3/28/16
 */
public class RedisCache {

    private StringRedisTemplate template;

    JedisTemplate jedisTemplate;

    public void cache() throws Exception {
        ValueOperations<String, String> ops = template.opsForValue();
        String key = "redis.test";
        if (!template.hasKey(key)) {
            ops.set(key, "foo");
        }
        System.out.println("Found key = "+key+ ", value = " +ops.get(key));
    }

}
