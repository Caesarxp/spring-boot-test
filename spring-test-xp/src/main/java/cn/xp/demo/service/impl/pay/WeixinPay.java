package cn.xp.demo.service.impl.pay;

import cn.xp.demo.common.annotations.PayCode;
import cn.xp.demo.service.IPay;
import cn.xp.demo.service.PayStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2021/1/14 16:32
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@PayCode(value = "weixin", name = "微信支付")
@Slf4j
@Service
public class WeixinPay implements IPay {
    @Override
    public boolean support(String code) {
        return"weixin".equals(code);
    }
    @PostConstruct
    public void init() {
        PayStrategyFactory.register("weixin", this);
    }
    @Override
    public void pay() {
        System.out.println("====发起微信支付=====");
        log.info("====发起微信支付===");
    }
}
