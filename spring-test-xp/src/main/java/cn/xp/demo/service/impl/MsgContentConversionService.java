package cn.xp.demo.service.impl;

import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2021/2/20 14:46
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Service
public class MsgContentConversionService {

    //查询内容，应用，底层

    public void conversion(Integer code) {
        MsgContentFactory.get(code).conversionMsgContent(11L,null,null,null);
    }
}
