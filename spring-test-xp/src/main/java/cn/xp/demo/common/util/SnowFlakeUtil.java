package cn.xp.demo.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @Description: 雪花算法生成
 * @Author: xp
 * @CreateDate: 2020/12/8 15:55
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public class SnowFlakeUtil {

    private long machineId ;
    private long dataCenterId ;


    public SnowFlakeUtil(long machineId, long dataCenterId) {
        this.machineId = machineId;
        this.dataCenterId = dataCenterId;
    }

    /**
     * 成员类，SnowFlakeUtil的实例对象的保存域
     */
    private static class IdGenHolder {
        private static final SnowFlakeUtil instance = new SnowFlakeUtil();
    }

    /**
     * 外部调用获取SnowFlakeUtil的实例对象，确保不可变
     */
    public static SnowFlakeUtil get() {
        return IdGenHolder.instance;
    }

    /**
     * 初始化构造，无参构造有参函数，默认节点都是0
     */
    public SnowFlakeUtil() {
        this(0L, 0L);
    }

    private Snowflake snowflake = IdUtil.createSnowflake(machineId,dataCenterId);

    public synchronized long id(){
        return snowflake.nextId();
    }

    public static Long getId() {
        return SnowFlakeUtil.get().id();
    }
}
