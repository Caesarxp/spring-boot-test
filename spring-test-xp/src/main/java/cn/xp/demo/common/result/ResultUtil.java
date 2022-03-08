package cn.xp.demo.common.result;

import cn.xp.demo.common.enums.ErrorEnum;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2020/9/10 11:39
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ErrorEnum.SUCCESS.getErrorCode());
        result.setMsg(ErrorEnum.SUCCESS.getErrorMsg());
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
