package cn.xp.demo.entity;

import lombok.Data;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2021/2/20 10:23
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Data
public class BodyText {
    /**
     * 消息类型:1-普通文本,2-普通文件消息，可以是图片、音频、视频消息,3-卡片消息
     */
    private Integer msgType;
    /**
     * 内容
     */
    private String bodyText;
}
