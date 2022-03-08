package cn.xp.demo.controller;


import cn.xp.demo.common.result.Result;
import cn.xp.demo.service.ITpShorturlInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 短链 前端控制器
 * </p>
 *
 * @author 熊鹏
 * @since 2022-01-20
 */
@RestController
@RequestMapping("/tp-shorturl-info")
public class TpShorturlInfoController {
    @Autowired
    private ITpShorturlInfoService iTpShorturlInfoService;

    @GetMapping("/get/{code}")
    public Result get(@PathVariable String code){
        return Result.ok(iTpShorturlInfoService.getUrl(code));
    }

}
