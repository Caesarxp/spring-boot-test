package cn.xp.demo.service.impl;

import cn.xp.demo.service.IMsgContentConversion;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Description: 消息内容
 * @Author: xp
 * @CreateDate: 2021/2/20 14:00
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Slf4j
public abstract class MsgContentConversionBaseAbstract implements IMsgContentConversion {



    @Override
    public String conversionMsgContent(Long contentId, Map<String, Object> reqParam, String[] param, String[] img) {
        return null;
    }

    @Override
    public String conversionSuggestionMenu(Long contentId, Map<String, Object> reqParam) {
        log.info("===内容ID-{}的悬浮菜单转化：{}",contentId,"悬浮菜单");
        return "悬浮菜单";
    }


}
