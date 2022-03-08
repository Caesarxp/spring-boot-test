package cn.xp.demo.controller;//package cn.xp.demo.controller;
//
//import cn.xp.demo.common.cache.SimpleDistrictCacheManager;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.xml.ws.Action;
//
///**
// * @description: 行政编码接口服务
// * @Date : 2019/5/5 下午4:11
// * @Author : 石冬冬-Seig Heil
// */
//@RestController
//@RequestMapping("/dictionaryReg")
//@Api(description = "行政编码",tags = "行政编码")
//public class DictionaryRegController {
//
//    final String LOG_TITLE = "【行政编码】";
//
//    @Autowired
//    SimpleDistrictCacheManager simpleDistrictCacheManager;
//
//    /**
//     * 查询省份列表
//     * @return
//     */
//    @GetMapping("/queryProvinces")
//    @ApiOperation("查询省份列表")
//    @Override
//    public Result<List<SimpleDistrictRe>> queryProvinces() {
//        return simpleDistrictCacheManager.queryProvinces();
//    }
//
//}
