package cn.xp.demo.component;//package cn.xp.demo.component;
//
//import cn.hutool.core.lang.Snowflake;
//import cn.xp.demo.orm.model.entity.BusinessTemplateInfo;
//import cn.xp.demo.service.RedisService;
//import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
//import lombok.SneakyThrows;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.text.MessageFormat;
//
///**
// * @Description: TODO
// * @Author: xp
// * @CreateDate: 2021/3/3 17:59
// * @UpdateUser: 熊鹏
// * @Version: 1.0
// */
//@Component
//public class CustomIdGenerator implements IdentifierGenerator {
//    @Autowired
//    private RedisService redisService;
//
//    @Override
//    public Number nextId(Object entity) {
//        //雪花id
//        Snowflake snowflake = new Snowflake(1l,2l);
//        return snowflake.nextId();
//    }
//
//    @SneakyThrows
//    @Override
//    public String nextUUID(Object entity) {
//        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
//        BusinessTemplateInfo templateInfo = (BusinessTemplateInfo)entity;
//        Integer type = templateInfo.getBusinessBelong();
//        System.out.println(templateInfo.getBusinessBelong());
//        String key = MessageFormat.format("{0}:{1}:{2}:{3}",  "sys","tableId","template",type);
//        long l = redisService.incr(key,1);
//        String value = StringUtils.leftPad(String.valueOf(l), 6, "0");
//        if (type == 2){
//            value = "CY"+value;
//        }
//        return value;
//    }
//}
