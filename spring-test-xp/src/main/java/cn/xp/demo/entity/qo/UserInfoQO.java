package cn.xp.demo.entity.qo;


import cn.xp.demo.common.annotations.isMobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="用户请求",description="请求参数类" )
public class UserInfoQO {
//    @NotNull
    @ApiModelProperty(value = "用户名称",example="xp")
    private String userName;

    @ApiModelProperty(value = "用户邮件",example="xp")
    private String userMail;

    @isMobile
    @ApiModelProperty(value = "用户手机号",example="xp")
    private String userNumber;

//    @Length(min = 6,max = 12)
    @ApiModelProperty(value = "账号",example="xp")
    private String loginCode;

    @ApiModelProperty(value = "密码",example="xp")
    private String loginPass;


}
