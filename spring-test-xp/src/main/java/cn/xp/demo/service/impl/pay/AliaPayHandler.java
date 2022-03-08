package cn.xp.demo.service.impl.pay;

import cn.xp.demo.component.PayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2021/1/14 17:29
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Slf4j
@Service
public class AliaPayHandler extends PayHandler {
    @Override
    public void pay(String code) {
        if ("alia".equals(code)) {
            log.info("===发起支付宝支付===");
        } else {
            getNext().pay(code);
        }
    }

}
