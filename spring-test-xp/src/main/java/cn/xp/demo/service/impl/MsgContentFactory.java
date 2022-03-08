package cn.xp.demo.service.impl;

import cn.xp.demo.service.IMsgContentConversion;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: 消息内容工厂
 * @Author: xp
 * @CreateDate: 2021/2/20 14:21
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */

public class MsgContentFactory {

    private static Map<Integer, IMsgContentConversion> CONVERSION_TYPE = new HashMap<>();

    public static void register(Integer code, IMsgContentConversion msgContentConversion)   {
        if (Objects.nonNull(code)) {
            CONVERSION_TYPE.put(code, msgContentConversion);
        }
    }
    public static IMsgContentConversion get(Integer code) {
        return CONVERSION_TYPE.get(code);
    }
}
