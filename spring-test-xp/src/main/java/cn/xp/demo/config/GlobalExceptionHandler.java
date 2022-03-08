package cn.xp.demo.config;

import cn.xp.demo.common.enums.ErrorEnum;
import cn.xp.demo.common.exception.DefinitionException;
import cn.xp.demo.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2020/9/10 11:32
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public Result bizExceptionHandler(DefinitionException e) {
        return Result.error(e);
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Result bindExceptionHandler(BindException e){
        log.error("参数校验错误：{}",e);
        return Result.error(9999,e.getBindingResult().getAllErrors().toString());
    }
    /**
     * 处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler( Exception e) {
        log.error("服务器错误：{}",e);
        return Result.error(ErrorEnum.INTERNAL_SERVER_ERROR);
    }


}
