package cn.xp.demo.common.cache;//package cn.xp.demo.common.cache;
//
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
///**
// * @description: 行政编码-缓存管理器
// * @Date : 2019/5/5 下午5:32
// * @Author : 石冬冬-Seig Heil
// */
//@Component
//@Slf4j
//public class SimpleDistrictCacheManager extends AbstractCacheManager<String,String,Result<List<SimpleDistrictRe>>> {
//
//    @Autowired
//    DiamondConfig diamondConfig;
//
//    @Autowired
//    DictionaryRegFacade dictionaryRegFacade;
//    /**
//     * short name
//     */
//    final String SHORT_NAME = CacheShortName.simpleDistrictCache.name();
//    /**
//     * 省份列表缓存key
//     */
//    final String PROVINCE_CACHE_KEY = "provinceCache";
//    /**
//     * 默认失效时间-2小时（单位秒）
//     */
//    final long DEFAULT_EXPIRE_SECONDS = 7200;
//
//    /**
//     * 查询省份列表
//     * @return
//     */
//    public Result<List<SimpleDistrictRe>> queryProvinces(){
//        if(!useCache()){
//            return dictionaryRegFacade.queryProvinces();
//        }
//        Result<List<SimpleDistrictRe>> queryResult;
//        try {
//            CacheContext<Result<List<SimpleDistrictRe>>> context = CacheContext.<Result<List<SimpleDistrictRe>>>builder()
//                    .key(PROVINCE_CACHE_KEY).reference(TypeReferences.SIMPLE_DISTRICT_TYPE).expireSeconds(DEFAULT_EXPIRE_SECONDS)
//                    .callback(() -> Optional.ofNullable(dictionaryRegFacade.queryProvinces())).build();
//            queryResult = primaryCache().get(PROVINCE_CACHE_KEY,() -> super.getFromSecondary(context));
//        } catch (ExecutionException e) {
//            log.info("{} focus on an exception,then execute queryDB",SHORT_NAME,e);
//            queryResult = dictionaryRegFacade.queryProvinces();
//            log.info("{} focus on an exception,then execute value={}",SHORT_NAME, JSONObject.toJSONString(queryResult));
//        }
//        return queryResult;
//    }
//
//    @Override
//    public Cache<String, Result<List<SimpleDistrictRe>>> primaryCache() {
//        return SimpleDistrictCacheFactory.get();
//    }
//
//    @Override
//    public boolean useCache() {
//        boolean useCache = cacheSwitch().simpleDistrictEnable;
//        log.debug("{} useCache={}",SHORT_NAME,useCache);
//        return useCache;
//    }
//
//    @Override
//    public String shortName() {
//        return SHORT_NAME;
//    }
//
//}
