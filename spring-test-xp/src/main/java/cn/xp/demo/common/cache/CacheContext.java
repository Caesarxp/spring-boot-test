package cn.xp.demo.common.cache;

import com.alibaba.fastjson.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @description: 缓存上下文对象
 * @Date : 2019/5/10 下午12:05
 * @Author : 石冬冬-Seig Heil
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CacheContext<T> {
    /**
     * 缓存key
     */
    String key;
    /**
     * 转换类型
     * 这里指缓存转换成JSON字符串存储，但是取出意味着需要转换对应的类类型
     */
    TypeReference<T> reference;
    /**
     * 回调函数，该回调接口意味着如果二级缓存没有将会通过查询db方式获取回调结果刷新到二级缓存中
     */
    Supplier<Optional<T>> callback;
    /**
     * 二级缓存失效时间(单位：秒)
     */
    long expireSeconds;
}
