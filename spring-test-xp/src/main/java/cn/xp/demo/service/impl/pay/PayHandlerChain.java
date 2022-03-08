package cn.xp.demo.service.impl.pay;

import cn.xp.demo.component.PayHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 责任链解决多支付问题
 * @Author: xp
 * @CreateDate: 2021/1/14 17:38
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Service
public class PayHandlerChain implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;
    private PayHandler header;


    public void handlePay(String code) {
        header.pay(code);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, PayHandler> beansOfTypeMap = applicationContext.getBeansOfType(PayHandler.class);
        if (beansOfTypeMap == null || beansOfTypeMap.size() == 0) {
            return;
        }
        List<PayHandler> handlers = beansOfTypeMap.values().stream().collect(Collectors.toList());
        for (int i = 0; i < handlers.size(); i++) {
            PayHandler payHandler = handlers.get(i);
            if (i != handlers.size() - 1) {
                payHandler.setNext(handlers.get(i + 1));
            }
        }
        header = handlers.get(0);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
