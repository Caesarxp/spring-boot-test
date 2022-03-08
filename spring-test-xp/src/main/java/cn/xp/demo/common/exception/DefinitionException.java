package cn.xp.demo.common.exception;

import cn.xp.demo.common.enums.ErrorEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 自定义异常
 * @Author: xp
 * @CreateDate: 2020/9/10 11:28
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Setter
@Getter
public class DefinitionException extends RuntimeException{
    protected Integer errorCode;

    public DefinitionException(){

    }
    public DefinitionException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
    }
    public DefinitionException(ErrorEnum errorEnum) {
        this(errorEnum.getErrorCode(), errorEnum.getErrorMsg());
    }


    @Override
    public String toString() {
        return String.format("[code=%s, message=%s]", this.errorCode, this.getMessage());
    }

}
