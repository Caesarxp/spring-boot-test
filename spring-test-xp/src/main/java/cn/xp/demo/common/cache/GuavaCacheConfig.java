package cn.xp.demo.common.cache;//package cn.xp.demo.common.cache;
//
//import com.google.common.cache.CacheBuilder;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@Slf4j
//public class GuavaCacheConfig {
//    /**
//     * 初始化缓存相关参数
//     * 行政编码-缓存配置（直营）
//     * @return
//     */
//    @Bean
//    Cache<String,Result<List<SimpleDistrictRe>>> simpleDistrictCacheZy(){
//        log.info("start build simpleDistrictCacheZy arguments");
//        return CacheBuilder.newBuilder()
//                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
//                .concurrencyLevel(8)
//                //设置写缓存后6小时过期
//                .expireAfterWrite(1, TimeUnit.HOURS)
//                //设置缓存容器的初始容量为10
//                .initialCapacity(32)
//                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
//                .maximumSize(20)
//                //设置要统计缓存的命中率
//                .recordStats()
//                //设置缓存的移除通知
//                .removalListener(notification -> log.info("simpleDistrictCacheZy remove cache,key={},cause={}",notification.getKey(),notification.getCause()))
//                .build();
//    }
//
//    /**
//     * 初始化缓存相关参数
//     * 行政编码-缓存配置（渠道）
//     * @return
//     */
//    @Bean
//    Cache<String,Result<List<SimpleDistrictRe>>> simpleDistrictCacheQd(){
//        log.info("start build simpleDistrictCacheQd arguments");
//        return CacheBuilder.newBuilder()
//                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
//                .concurrencyLevel(8)
//                //设置写缓存后6小时过期
//                .expireAfterWrite(1, TimeUnit.HOURS)
//                //设置缓存容器的初始容量为10
//                .initialCapacity(32)
//                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
//                .maximumSize(20)
//                //设置要统计缓存的命中率
//                .recordStats()
//                //设置缓存的移除通知
//                .removalListener(notification -> log.info("simpleDistrictCacheQd remove cache,key={},cause={}",notification.getKey(),notification.getCause()))
//                .build();
//    }
//}
//
