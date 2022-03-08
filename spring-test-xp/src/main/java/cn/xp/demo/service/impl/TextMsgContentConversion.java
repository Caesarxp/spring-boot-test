package cn.xp.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2021/2/20 14:09
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Service
@Slf4j
public class TextMsgContentConversion extends MsgContentConversionBaseAbstract {
    @PostConstruct
    public void init() {
        MsgContentFactory.register(1, this);
    }
    @Override
    public String conversionMsgContent(Long contentId, Map<String, Object> reqParam, String[] param, String[] img) {
        String msg = "文本消息";
        log.info("==内容ID{}转化为:{}",contentId,msg);
        System.out.println("========="+msg);
        return msg;
    }
}
