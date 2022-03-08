package cn.xp.demo.common.result;

import cn.xp.demo.common.enums.ErrorEnum;
import cn.xp.demo.common.exception.DefinitionException;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 返回结果类
 * @Author: xp
 * @CreateDate: 2020/9/10 9:41
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private T data;
    public Result() {
    }

    public Result(ErrorEnum errorEnum) {
//        this.success = success;
       this.setCode(errorEnum.getErrorCode());
       this.setMsg(errorEnum.getErrorMsg());
    }

    public  Result(Integer code,String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    @Override
    public String toString() {
        return String.format("[code=%s, msg=%s, data=%s]", this.getCode(), this.getCode(), this.getData());
    }
    /**
     * 成功并返回数据实体类
     * @param data
     * @return
     */
    public static <T> Result<T> ok(T data){
        return new Result<T>(0000,"返回成功", data);
    }

    /**
     * 成功，但无数据实体类返回
     * @return
     */
    public static <E> Result<E> ok(){
        return new Result<>(0000, "返回成功", null);
    }
    /**
     * 失败，有自定义返回类型
     * @param ex
     * @param <E>
     * @return
     */
    public static <E> Result<E> error(DefinitionException ex){
        return new Result<>(ex.getErrorCode(),ex.getMessage(),null);
    }
    /**
     * 失败
     * @param code
     * @param msg
     * @param <E>
     * @return
     */
    public static <E> Result<E> error(Integer code, String msg){
        return new Result<>(code,msg,null);
    }

    public static <E> Result<E> error(ErrorEnum errorEnum){
        return new Result<>(errorEnum.getErrorCode(),errorEnum.getErrorMsg(),null);
    }

}
