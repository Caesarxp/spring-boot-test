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
 * @CreateDate: 2021/1/14 16:30
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Slf4j
@PayCode(value = "alia", name = "支付宝支付")
@Service
public class AliaPay implements IPay {

    @PostConstruct
    public void init() {
        PayStrategyFactory.register("aliaPay", this);
    }

    @Override
    public boolean support(String code) {
        return"alia".equals(code);
    }

    @Override
    public void pay() {
        log.info("===发起支付宝支付===");
    }
}
