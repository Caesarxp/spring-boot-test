package cn.xp.demo.controller;


import cn.xp.demo.common.base.BaseController;
import cn.xp.demo.common.result.Result;
import cn.xp.demo.orm.model.UserInfo;
import cn.xp.demo.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xp
 * @since 2020-06-17
 */
@RestController
@Slf4j
@RequestMapping("/user-info")
public class UserInfoController extends BaseController {
    @Autowired
    private IUserInfoService userInfoService;
    @GetMapping("test")
    public String getTest( String name){
        log.info("{}测试",name);
        return name;
    }
    @GetMapping("user/{id}")
    public Result<UserInfo> getUser(@PathVariable  Long id){
        UserInfo userInfo = userInfoService.getById(id);
        return Result.ok(userInfo);
    }
    @GetMapping("/xss")
    public String xss(String params){
        log.error("{}测试"+params);
        return params;
    }
    @PostMapping("/xsss")
    public String xsss(@RequestBody Map<String,String> body){
        log.error("{}测试"+body);
        return body.get("params");
    }
}
