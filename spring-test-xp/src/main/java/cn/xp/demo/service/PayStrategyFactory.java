package cn.xp.demo.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2021/1/14 17:13
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public class PayStrategyFactory {
    private static Map<String, IPay> PAY_REGISTERS = new HashMap<>();


    public static void register(String code, IPay iPay) {
        if (null != code && !"".equals(code)) {
            PAY_REGISTERS.put(code, iPay);
        }
    }


    public static IPay get(String code) {
        return PAY_REGISTERS.get(code);
    }

}
