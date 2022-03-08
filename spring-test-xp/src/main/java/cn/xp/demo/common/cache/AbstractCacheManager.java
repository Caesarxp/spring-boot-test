package cn.xp.demo.common.cache;//package cn.xp.demo.common.cache;
//
//import cn.xp.demo.service.RedisService;
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.collect.Maps;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Map;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.Set;
//
///**
// * @description: 抽象缓存管理器
// * @Date : 2019/4/22 下午6:37
// * @Author : 石冬冬-Seig Heil
// */
//@Slf4j
//public abstract class AbstractCacheManager<K,HK,V> implements CacheManage<K,HK,V> {
//    /**
//     * 开关
//     */
//    final TypeReference<DiamondConfig.CacheEnable> REFERENCE = new TypeReference<DiamondConfig.CacheEnable>(){};
//    /**
//     * 空值
//     */
//    final Optional EMPTY = Optional.empty();
//
//    @Autowired
//    RedisService redisService;
//
//    @Autowired
//    DiamondConfig diamondConfig;
//
//    @Autowired
//    SecondaryCache secondaryCache;
//
//    /**
//     * 从二级缓存 加载数据，二级缓存没有值则调用 callback 从数据库读取并刷新到二级缓存
//     * @param context
//     * @param <T>
//     * @return
//     * */
//    protected <T> T getFromSecondary(CacheContext<T> context){
//        String key = context.key;
//        String cacheKey = cacheKey();
//        Optional<T> dbValue = EMPTY;
//        try {
//            String secondaryValue = secondaryCache.getValueFromSecondary(key,cacheKey);
//            log.debug("getFromSecondary,key={},secondaryValue={}",cacheKey,secondaryValue);
//            if(null != secondaryValue){
//                return JSONObject.parseObject(secondaryValue,context.reference);
//            }
//            dbValue = context.callback.get();
//            if(null == dbValue || !dbValue.isPresent()){
//                log.debug("getFromDB,shortName={},hashKey={},not callback",shortName(),key);
//                return (T)EMPTY.get();
//            }
//            log.debug("getFromDB,shortName={},hashKey={},dbValue={}",shortName(),key,JSONObject.toJSONString(dbValue.get()));
//            secondaryCache.setValueForSencondary(key,cacheKey,context.expireSeconds,dbValue);
//            return dbValue.get();
//        } catch (Exception e) {
//            log.error("getFromSecondary exception,shortName={},hashKey={}",shortName(),key,e);
//            return null == dbValue ? (T)EMPTY.get() : dbValue.get();
//        }
//    }
//
//
//    /**
//     * 获取缓存开关配置
//     * @return
//     */
//    protected DiamondConfig.CacheEnable cacheSwitch(){
//        return diamondConfig.of(diamondConfig.cacheSwitch,REFERENCE);
//    }
//
//    @Override
//    public SecondaryCache secondaryCache() {
//        return SecondaryCacheFactory.create(RedisSecondaryCache.class);
//    }
//
//    @Override
//    public String cacheKey() {
//        return redisService.getKeyWithSystemCode(shortName());
//    }
//
//    @Override
//    public void invalidate(Object o, Object o2) {
//        primaryCache().invalidate(o);
//        secondaryCache().invalidate(redisService.getKeyWithSystemCode(o.toString()),o2);
//    }
//
//    @Override
//    public void invalidateAll(Object o) {
//        primaryCache().invalidateAll();
//        secondaryCache().invalidateAll(redisService.getKeyWithSystemCode(o.toString()));
//    }
//
//    @Override
//    public boolean useCache() {
//        return true;
//    }
//
//    @Override
//    public Map<String, V> showAsMap() {
//        Map<String,V> newMap = Maps.newHashMap();
//        primaryCache().asMap().entrySet().forEach(entry -> newMap.put(Objects.toString(entry.getKey()),entry.getValue()));
//        return newMap;
//    }
//
//    @Override
//    public Set<K> keys() {
//        return primaryCache().asMap().keySet();
//    }
//}
//
//
