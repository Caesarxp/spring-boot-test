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
import java.time.LocalDate;

/**
 * <p>
 * 短链数据统计
 * </p>
 *
 * @author 熊鹏
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tp_shorturl_report")
@ApiModel(value="TpShorturlReport对象", description="短链数据统计")
public class TpShorturlReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "应用类型-服务来源  SELF-自有能力，THIRD-第三方")
    private String serviceOrigin;

    @ApiModelProperty(value = "应用名称")
    private String appName;

    @ApiModelProperty(value = "短链个数")
    private String shorturlNum;

    @ApiModelProperty(value = "下发量")
    private Long sendNum;

    @ApiModelProperty(value = "点击数量")
    private Long clickNum;

    @ApiModelProperty(value = "点击率")
    private Long clickRate;

    @ApiModelProperty(value = "平台标识")
    private String platformCode;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "日期")
    private LocalDate reportTime;

    @ApiModelProperty(value = "扩展字段")
    private String extend;


}
