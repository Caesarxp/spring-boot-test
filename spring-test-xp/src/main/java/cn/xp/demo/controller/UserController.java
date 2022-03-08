package cn.xp.demo.controller;


import cn.xp.demo.common.base.BaseController;
import cn.xp.demo.common.enums.ErrorEnum;
import cn.xp.demo.common.exception.DefinitionException;
import cn.xp.demo.common.result.Result;
import cn.xp.demo.entity.qo.UserInfoQO;
import cn.xp.demo.orm.model.UserInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xp
 * @since 2020-11-18
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @ApiOperation(value = "测试类")
    @PostMapping("/test")
    public Result<UserInfo> test(@Validated UserInfoQO qo){
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(qo,userInfo);
        return Result.ok(userInfo);
    }

    @ApiOperation(value = "手机号校验，利用validated，自定义注解抛出异常")
    @PostMapping("/check")
    public Result check(@Validated UserInfoQO qo){
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(qo,userInfo);
        return Result.ok();
    }
    @ApiOperation(value = "手机号校验2，利用封装result响应")
    @PostMapping("/check2")
    public Result check2(UserInfoQO qo){
        if (StringUtils.isEmpty(qo.getUserNumber())){
            return Result.error(ErrorEnum.NOT_USERNUMBER);
        }
        return Result.ok();
    }
    @ApiOperation(value = "手机号校验2，利用自定义异常，依赖自定义处理器GlobalExceptionHandler")
    @PostMapping("/check3")
    public Result check3(UserInfoQO qo){
        if (StringUtils.isEmpty(qo.getUserNumber())){
            throw new DefinitionException(ErrorEnum.NOT_USERNUMBER);
        }
        return Result.ok();
    }


    //短链转化
    //存储数据库
    //随机时间



    //跳转
    @GetMapping("{shortUrl}")
    public ModelAndView redirect(@PathVariable String shortUrl, ModelAndView mav){

        // 获取对应的长链接（若短链接不存在，则跳转到默认页面）
//        TranlationVo tranlationVo = translationService.getUrlByShortUrl(CommonConstant.PRIFIX_OF_SHORT_URL + shortUrl);
//        String url = (tranlationVo == null) ? CommonConstant.DEFAULT_URL : tranlationVo.getUrl();

        // 跳转
//        mav.setViewName("redirect:" + url);

        return mav;
    }



}
