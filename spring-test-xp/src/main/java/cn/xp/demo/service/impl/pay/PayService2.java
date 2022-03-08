package cn.xp.demo.service.impl.pay;

import cn.xp.demo.common.annotations.PayCode;
import cn.xp.demo.service.IPay;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 使用监听器，利用注解消除if else
 * TODO 需要研究 ApplicationListener
 * @Author: xp
 * @CreateDate: 2021/1/14 16:44
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Service
public class PayService2 implements ApplicationListener<ContextRefreshedEvent> {
    private static Map<String, IPay> payMap = null;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(PayCode.class);

        if (beansWithAnnotation != null) {
            payMap = new HashMap<>();
            beansWithAnnotation.forEach((key, value) ->{
                String bizType = value.getClass().getAnnotation(PayCode.class).value();
                payMap.put(bizType, (IPay) value);
            });
        }
    }

    public void pay(String code) {
        payMap.get(code).pay();
    }

}
