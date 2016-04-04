/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Author  : panxin
 * Date    : 8:20 PM 3/26/16
 */
@ComponentScan({"graduation.hnust.simplebook"})
@SpringBootApplication
public class ApplicationWebStarter {

    //@Autowired
    private StringRedisTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationWebStarter.class, args);
    }

    //@Override
    public void xxx(String... strings) throws Exception {
        ValueOperations<String, String> ops = template.opsForValue();
        String key = "redis.test";
        if (!template.hasKey(key)) {
            ops.set(key, "foo");
        }
        System.out.println("Found key = "+key+ ", value = " +ops.get(key));
    }
}
