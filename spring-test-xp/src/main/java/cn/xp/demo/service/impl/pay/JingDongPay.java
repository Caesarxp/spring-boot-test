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
@PayCode(value = "jingdong", name = "京东支付")
@Slf4j
@Service
public class JingDongPay implements IPay {
    @PostConstruct
    public void init() {
        PayStrategyFactory.register("jingdong", this);
    }
    @Override
    public boolean support(String code) {
        return"jingdong".equals(code);
    }
    @Override
    public void pay() {
        log.info("=====发起京东支付=====");
    }
}
