package cn.xp.demo.service.impl.pay;

import cn.xp.demo.service.PayStrategyFactory;
import org.springframework.stereotype.Service;

/**
 * @Description: 策略模式和工厂模式
 * @Author: xp
 * @CreateDate: 2021/1/14 17:18
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Service
public class PayService5{
    public void toPay(String code) {
        PayStrategyFactory.get(code).pay();
    }
}
