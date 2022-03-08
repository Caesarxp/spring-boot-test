package cn.xp.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2021/2/20 14:15
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Service
@Slf4j
public class FileMsgContentConversion extends MsgContentConversionBaseAbstract {

    @PostConstruct
    public void init() {
        MsgContentFactory.register(2, this);
        MsgContentFactory.register(5, this);
        MsgContentFactory.register(6, this);
    }


    @Override
    public String conversionMsgContent(Long contentId, Map<String, Object> reqParam, String[] param, String[] img) {
        String msg = "文件消息";
        log.info("==内容ID{}转化为:{}",contentId,msg);
        System.out.println("========="+msg);
        conversionSuggestionMenu(contentId,reqParam);
        return msg;
    }
}
