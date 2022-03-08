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
 * 短链
 * </p>
 *
 * @author 熊鹏
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tp_shorturl_info")
@ApiModel(value="TpShorturlInfo对象", description="短链")
public class TpShorturlInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "原链接")
    private String originalUrl;

    @ApiModelProperty(value = "链接名称")
    private String urlName;

    @ApiModelProperty(value = "短链接")
    private String shortUrl;

    @ApiModelProperty(value = "申请状态：0-失效，1-有效")
    private Integer urlStatus;

    @ApiModelProperty(value = "生成时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "截止时间")
    private LocalDateTime byTime;

    @ApiModelProperty(value = "审核原因")
    private String remark;

    @ApiModelProperty(value = "平台标识")
    private String platformCode;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "应用名称")
    private String appName;

    @ApiModelProperty(value = "扩展字段")
    private String extend;


}
