package cn.xp.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 消息发送队列（后期改造成消息中间件）
 * </p>
 *
 * @author 熊鹏
 * @since 2021-03-27
 */
@Data
public class MsgSendQueue implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户手机号")
    private String userNumber;

    @ApiModelProperty(value = "状态,0-未处理，1-已处理，2-下发失败")
    private Integer status;

    @ApiModelProperty(value = "下发来源：1、任务下发；2、场景预览；3、任务预览；4、智能回复;5、外部接口调用；6、身份认证调用")
    private Integer downSource;

    @ApiModelProperty(value = "消息类型：1、文本；2、文件；3、卡片")
    private Integer msgType;

    @ApiModelProperty(value = "发送时间")
    private LocalDateTime sendTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "发送内容")
    private String sendContent;

    @ApiModelProperty(value = "通道编码")
    private String channelCode;

    @ApiModelProperty(value = "队列类型：（可调优先级）")
    private Integer queueType;

    @ApiModelProperty(value = "消息的appid")
    private String appId;

    @ApiModelProperty(value = "消息号的chatbbotId")
    private String chatbbotId;

    public static void main(String[] args) {
        List<MsgSendQueue> msgSendQueues = new ArrayList<>();
        String code = "zf";
        for (int i = 0; i < 3; i++) {
            MsgSendQueue m = new MsgSendQueue();
            m.setChannelCode(code);
            m.setAppId(String.valueOf(i));
            msgSendQueues.add(m);
        }String ycode = "yd";
        for (int i = 0; i < 3; i++) {
            MsgSendQueue m = new MsgSendQueue();
            m.setChannelCode(ycode);
            m.setAppId(String.valueOf(i));
            msgSendQueues.add(m);
        }
        Map<String, List<MsgSendQueue>> channelMsg = msgSendQueues.stream().collect(Collectors.groupingBy(MsgSendQueue::getChannelCode));
        System.out.println(channelMsg);
    }

}
