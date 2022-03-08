package cn.xp.demo.config;//package cn.xp.demo.config;
//
//
//
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//import java.util.List;
//
///**
// * @Description: 响应处理（为了封装给前端使用，保证分页组件的不变动)
// * @Author: xp
// * @CreateDate: 2021/1/11 17:57
// * @UpdateUser: 熊鹏
// * @Version: 1.0
// */
//@ControllerAdvice
//public class MvcResponseBodyAdvice implements ResponseBodyAdvice {
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class aClass) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//            Result result = (Result) o;
//            Object body = result.getBody();
//            if (body instanceof Page){
//                //分页转换
//                Page page = (Page) body;
//                List list = page.getRecords();
//                ResultPageResp resp = new ResultPageResp();
//                PageBean pageInfo = new PageBean();
//                pageInfo.setPageNum(page.getCurrent());
//                pageInfo.setPageSize(page.getPages());
//                pageInfo.setTotalCount(page.getSize());
//                pageInfo.setPageNum(page.getTotal());
//                resp.setList(list);
//                resp.setPageInfo(pageInfo);
//                result.setBody(resp);
//            }
//        return result;
//    }
//}
