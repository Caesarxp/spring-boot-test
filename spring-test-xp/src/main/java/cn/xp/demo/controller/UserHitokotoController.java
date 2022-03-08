package cn.xp.demo.controller;


import cn.xp.demo.common.base.BaseController;
import cn.xp.demo.common.result.Result;
import cn.xp.demo.common.result.ResultUtil;
import cn.xp.demo.common.util.JsonUtil;
import cn.xp.demo.entity.qo.UserHitokotoQO;
import cn.xp.demo.entity.vo.UserHitokotoVo;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 个人一言 前端控制器
 * </p>
 *
 * @author xp
 * @since 2020-08-25
 */
@RestController
@RequestMapping("/user-hitokoto")
public class UserHitokotoController extends BaseController {

    @PostMapping("test")
    public Result<UserHitokotoVo> getHitokoto(@RequestBody UserHitokotoQO qo) throws Exception {
        UserHitokotoVo vo =   getTest(qo);
        return ResultUtil.success(vo);
    }

    private static  String URL = "https://v1.hitokoto.cn/";
    public UserHitokotoVo getTest(UserHitokotoQO qo) throws Exception {
        TypeReference<UserHitokotoVo> ref = new TypeReference<UserHitokotoVo>(){};

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        HttpResponse response = client.execute(httpGet);
        String rspJson = EntityUtils.toString(response.getEntity(), "utf-8");
        UserHitokotoVo rspBean = JsonUtil.parseToObject(rspJson, ref);
        return  rspBean;
    }


}
