/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.common.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;

/**
 * Redis 缓存, 暂时用于缓存手机验证码
 *
 * Author  : panxin
 * Date    : 8:01 PM 3/28/16
 */
public class RedisHelper {

    private Jedis jedis;

    public static void main(String[] args) {
        RedisTemplate<String, String> template = new RedisTemplate();
        String random = template.randomKey();
        //template.set(random, null);
        //SetOperations<String, String> ops = SetOperations
        template.opsForSet();

        StringRedisTemplate template1 = new StringRedisTemplate();

    }

}
