package com.wcyc.upms.web.config.cache;

import org.crazycake.shiro.RedisManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * ehcache配置
 *
 * @author chen
 */
@Configuration
@EnableCaching
public class CacheConfig {



    private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

//    @Bean(name = "umpsRedisCacheManager")
//    @Primary
//    public RedisCacheManager upmsRedisCacheManager() {
//        logger.info("--------------redis cache init---------------");
//        RedisCacheManager slifeRedisCacheManager = new RedisCacheManager();
//        slifeRedisCacheManager.setRedisTemplate(redisTemplate);
//        logger.info("--------------redis cache ---------------" + slifeRedisCacheManager);
//        return slifeRedisCacheManager;
//    }


    @Bean(name = "redisCacheManager")
    @Primary
    public org.crazycake.shiro.RedisCacheManager redisCacheManager() {
        logger.info("--------------redis cache init---------------");
        org.crazycake.shiro.RedisCacheManager redisCacheManager = new org.crazycake.shiro.RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        logger.info("--------------redis cache ---------------" + redisCacheManager);
        return redisCacheManager;
    }


    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.database}")
    private int database;

    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPassword(password);
        redisManager.setPort(port);
        redisManager.setDatabase(database);
        return redisManager;
    }

}
