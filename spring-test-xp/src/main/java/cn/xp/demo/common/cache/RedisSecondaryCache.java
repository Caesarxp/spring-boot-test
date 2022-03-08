package cn.xp.demo.common.cache;//package cn.xp.demo.common.cache;
//
//import cn.xp.demo.service.RedisService;
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Optional;
//
///**
// * @description: Redis二级缓存
// * @Date : 2019/5/10 上午11:59
// * @Author : 石冬冬-Seig Heil
// */
//public class RedisSecondaryCache implements SecondaryCache{
//
//    @Autowired
//    RedisService redisService;
//
//    @Override
//    public String getValueFromSecondary(String key,String cacheKey) {
//        Object hashValue = redisService.hGet(cacheKey,key);
//        return null == hashValue ? null : hashValue.toString();
//    }
//
//    @Override
//    public <T> void setValueForSencondary(String key,String cacheKey,long expireSeconds, Optional<T> value) {
//        redisService.hSet(cacheKey,key, JSONObject.toJSONString(value),expireSeconds);
//    }
//
//    @Override
//    public void invalidate(Object o, Object o2) {
//        redisService.hDel(o.toString(),o2.toString());
//    }
//
//    @Override
//    public void invalidateAll(Object o) {
//        redisService.hDel(o.toString());
//    }
//}
//
//
