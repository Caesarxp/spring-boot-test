package cn.xp.demo.orm.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 模板-基本表
 * </p>
 *
 * @author xp
 * @since 2021-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("business_template_info")
@ApiModel(value="BusinessTemplateInfo对象", description="模板-基本表")
public class BusinessTemplateInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "模板ID")
    private String templateCode;

    @ApiModelProperty(value = "模板名称")
    private String templateName;

    @ApiModelProperty(value = "所属行业（1互联网，2金融，3游戏，4邮箱，5短视频，6运营商，7教育，8交通，9房地产，10美妆，11党政，12执法，13医疗，14工业能源）")
    private Integer businessSort;

    @ApiModelProperty(value = "应用类型（1、服务类业务；2、营销类业务）")
    private Integer businessBelong;

    @ApiModelProperty(value = "上架状态（1、开；0、关）")
    private Integer onStatus;

    @ApiModelProperty(value = "模板状态(1、编辑中，2、素材审核，3、审核通过，4、审核不通过，5、素材过期失效)")
    private Integer templateStatus;

    @ApiModelProperty(value = "模板简介")
    private String templateIntro;

    @ApiModelProperty(value = "创建者")
    private String creater;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    @ApiModelProperty(value = "新增时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "1.拼图 2.人脸识别 3.动态参数 4.中间号 5.H5模板")
    private String functions;

    @ApiModelProperty(value = "拼图功能(1为有拼图功能，0为无)")
    private Integer puzzleFlag;

    @ApiModelProperty(value = "1.卡片 2.文本 3.多媒体（图片、视频、音频）")
    private Integer type;

    @ApiModelProperty(value = "内容id")
    private Long contentId;

    @ApiModelProperty(value = "排序")
    private Integer sort;


}
