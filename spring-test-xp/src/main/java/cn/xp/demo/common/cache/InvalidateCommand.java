package cn.xp.demo.common.cache;

/**
 * @description: 缓存失效命令接口
 * @Date : 2019/5/10 下午1:54
 * @Author : 石冬冬-Seig Heil
 */
public interface InvalidateCommand<K,HK> {
    /**
     * 清除指定k的hk对应的值
     * @param k
     * @param hk
     */
    void invalidate(K k, HK hk);
    /**
     * 清除指定k所有缓存
     * @param k
     */
    void invalidateAll(K k);
}
