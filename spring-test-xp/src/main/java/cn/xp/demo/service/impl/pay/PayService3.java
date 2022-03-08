package cn.xp.demo.service.impl.pay;

import cn.xp.demo.service.IPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Description: 内容
 * @Author: xp
 * @CreateDate: 2021/1/14 16:55
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Service
public class PayService3  {
    @Autowired
    private ApplicationContext applicationContext;
    private static final String SUFFIX = "Pay";

    public void toPay(String payCode) {
        ((IPay) applicationContext.getBean(getBeanName(payCode))).pay();
    }

    public String getBeanName(String payCode) {
        return payCode + SUFFIX;
    }
}
