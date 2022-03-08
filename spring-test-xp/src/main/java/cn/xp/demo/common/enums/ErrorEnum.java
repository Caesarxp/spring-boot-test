package cn.xp.demo.common.enums;

import java.util.Arrays;

public enum ErrorEnum {
    SUCCESS(200, "成功"),
    NO_PERMISSION(403,"你没得权限"),
    NO_AUTH(401,"你能不能先登录一下"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器跑路了"),
    NOT_USERNUMBER(901, "请绑定手机号"),

    ;

    /** 错误码 */
    private Integer errorCode;

    /** 错误信息 */
    private String errorMsg;

    ErrorEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
    //可用于匹配第三方接口响应码（排除其他返回码）
    public static ErrorEnum getErrorEnum(int code) {
        return Arrays.stream(ErrorEnum.values()).filter(x -> x.errorCode == code).findFirst().orElse(null);
    }
}
