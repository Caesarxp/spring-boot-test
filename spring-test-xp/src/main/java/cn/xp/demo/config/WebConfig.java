package cn.xp.demo.config;//package cn.xp.demo.config;
//
//import com.csp.microx.session.PermissionInterceptor;
//import com.csp.microx.session.SessionUserArgumentResolver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.util.List;
//
///**
// * @Description: 为解决MVC，json转化空值，list转化中出现序列化问题
// * @Author: xp
// * @CreateDate: 2021/1/12 11:01
// * @UpdateUser: 熊鹏
// * @Version: 1.0
// */
//
//@Configuration
//public class WebConfig extends WebMvcConfigurationSupport {
//
//    @Autowired
//    private SessionUserArgumentResolver resolver;
//
//    @Autowired
//    private PermissionInterceptor interceptor;
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        //在json转换之前先进行string转换
//        converters.add(new StringHttpMessageConverter());
//        //添加json转换
//        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        jackson2HttpMessageConverter.setObjectMapper(MyJsonMapper.getObjectMapper());
//        converters.add(jackson2HttpMessageConverter);
//        //5、追加默认转换器
//        super.addDefaultHttpMessageConverters(converters);
//    }
//
//    @Override
//    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(resolver);
//        super.addArgumentResolvers(argumentResolvers);
//    }
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceptor);
//        super.addInterceptors(registry);
//    }
//}
