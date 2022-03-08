package cn.xp.demo.entity.po;

import cn.xp.demo.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2020/6/16 17:30
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Data
public class BasePO  implements BaseModel {
    @ApiModelProperty(value = "创建时间",hidden = true)
    private LocalDate createTime;

    @ApiModelProperty(value = "更新时间",hidden = true)
    private LocalDate updateTime;

    //TODO 基本参数
}
