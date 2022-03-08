package cn.xp.demo.common.cache;

import java.util.Optional;

/**
 * @description: 二级缓存接口
 * @Date : 2019/5/10 上午11:53
 * @Author : 石冬冬-Seig Heil
 */
public interface SecondaryCache extends InvalidateCommand {
    /**
     * 从二级缓存获取值
     * @param key 小key
     * @param cacheKey 缓存key
     * @return
     */
    String getValueFromSecondary(String key, String cacheKey);
    /**
     * 设置二级缓存值
     * @param key 小key
     * @param cacheKey 缓存key
     * @param expireSeconds 缓存失效时间(单位：秒)
     * @param value 需要刷进缓存的回调接口值
     */
    <T> void setValueForSencondary(String key, String cacheKey, long expireSeconds, Optional<T> value);
}


