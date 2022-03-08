package cn.xp.demo.common.base;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 控制器基类
 * @Author: xp
 * @CreateDate: 2020/6/16 17:39
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Slf4j
public class BaseController {

    public static int cookieTimeOut=60*60*12*14;

    /**
     * 获取ip地址
     * @return
     */
    protected String getUserIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    //TODO 用户信息，对请求参数进行xss过滤
}
