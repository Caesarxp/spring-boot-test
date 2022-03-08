package cn.xp.plugin.cache;

import cn.xp.plugin.cache.properties.CacheConfigProperties;
import cn.xp.plugin.cache.support.CacheMessageListener;
import cn.xp.plugin.cache.support.RedisCaffeineCacheManager;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author xiongpeng
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(CacheConfigProperties.class)
public class CacheAutoConfiguration {

    @Bean
    @ConditionalOnBean(RedisTemplate.class)
    public RedisCaffeineCacheManager cacheManager(CacheConfigProperties cacheConfigProperties,
                                                  RedisTemplate<Object, Object> stringKeyRedisTemplate) {
        return new RedisCaffeineCacheManager(cacheConfigProperties, stringKeyRedisTemplate);
    }

    @Bean
    @ConditionalOnMissingBean(name = "stringKeyRedisTemplate")
    public RedisTemplate<Object, Object> stringKeyRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        return template;
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(CacheConfigProperties cacheConfigProperties,
                                                                       RedisTemplate<Object, Object> stringKeyRedisTemplate, RedisCaffeineCacheManager redisCaffeineCacheManager) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(stringKeyRedisTemplate.getConnectionFactory());
        CacheMessageListener cacheMessageListener = new CacheMessageListener(stringKeyRedisTemplate,
                redisCaffeineCacheManager);
        redisMessageListenerContainer.addMessageListener(cacheMessageListener,
                new ChannelTopic(cacheConfigProperties.getRedis().getTopic()));
        return redisMessageListenerContainer;
    }

}
