# 个人项目测试Demo

1. Swagger2，主题

使用国内的

可进行文档的导入导出

2. xxl-job

已实现

3. mybatis-plus



4. sharding-jdbc分库分表

需要考虑取模字段，已实现

配置需要严格按照格式要求，表名不可随便取

分库分表配置

5. 统一结果类

spring使用jackson组件进行序列化
可通过继承ObjectMapper，或者重新设置
处理完成，可选择是否为空，可选将null转化为""空字符串，但集合序列化会出现问题

响应转换处理

6. 统一异常处理

处理完成

7. 统一时间处理

处理完成

8. 统一安全处理？


9. 统一的脱敏处理？

10.切面日志处理

--------------------------
11.数据一致性和接口幂等性的保证

12.消息中间件的实用

13.mock测试


14.策略模式实用

15.docker部署支持

16.guava的使用

17. 短链的实现

18.jwt权限的实现

19. 接口权限和数据权限的处理



-----------微服务改造--------------

1.分布式锁redisson的实现

2.微服务的改造

# 说明

该项目为个人学习项目

微服务中，feign进行转发，会重置请求头，需要重写feign配置类，将请求头封装到下一个模块

@Component
@ConditionalOnClass({Feign.class, HystrixCommand.class, HystrixFeign.class, FeignContext.class})
public class FeignAutoConfiguration 


# 修改说明


## 功能简介

## 开发说明

配置分开化

### 如何部署项目


```
nohup java -jar cspapi-0.0.1.jar --server.port=6767 &   --指定端口运行

nohup java -jar microx-user-1.0.0-SNAPSHOT.jar &

nohup java -jar microx-third-part-1.0.0-SNAPSHOT.jar &

nohup java -jar microx-message-1.0.0-SNAPSHOT.jar &

nohup java -jar microx-csp-portal-1.0.0-SNAPSHOT.jar &

nohup java -jar microx-csp-admin-1.0.0-SNAPSHOT.jar &

nohup java -jar microx-content-1.0.0-SNAPSHOT.jar &

```
目前还没有设置生产和开发环境的分离，需要后续修改，然后命令

```
nohup java -jar cspapi-0.0.1.jar --spring.profiles.active=dev &

```

2. 直接打war包，可到pom中去修改

```
<packaging>jar</packaging>
```
改为
```
<packaging>war</packaging>
```
并打包放入到tomcat中执行


### 环境需求
jdk1.8
tomcat8.5

## 所用框架

1. SpringBoot 2.1.7.RELEASE
2. MyBatis-plus 3.1.7
3. druid 1.1.12

## 项目包结构说明
```
├─main
│  │  
│  ├─java
│  │   │
│  │   ├─cn.richinfo.mall----------------项目主代码
│  │   │          │
│  │   │          ├─common----------------项目公用的部分(业务中经常调用的类,例如常量,异常,注解，工具类)
│  │   │          │
│  │   │          ├─config----------------项目配置代码(例如mybtais-plus配置,druid,swagger配置等)
│  │   │          │
│  │   │          ├─core----------------项目运行的核心依靠(核心代码过滤器，请求拦截等实现)
│  │   │          │
│  │   │          ├─entity----------------项目业务代码（请求参数，返回参数，qo是查询参数，vo是返回参数，po是插入修改的请求参数自带创建和修改时间）
│  │   │          │
│  │   │          ├─controller----------------项目业务代码控制器（接口服务，都要集成BaseController）
│  │   │          │
│  │   │          ├─service----------------项目业务代码（接口服务serivice）
│  │   │          │
│  │   │          ├─orm----------------项目业务代码（dao层）
│  │   │          │
│  │   │          ├─GunsApplication类----------------以main方法启动springboot的类
│  │   │          │
│  │   │          └─GunsServletInitializer类----------------用servlet容器启动springboot的核心类
│  │   │
│  │   └─generator----------------mybatis-plus Entity生成器
│  │
│  ├─resources----------------项目资源文件
│  │     │
│  │     ├─config.properties----------------系统参数配置
│  │     │ 
│  │     ├─application.yml----------------springboot项目配置
│  │     │ 
│  │     └─logback-spring.xml----------------日志相关配置
│  
```
注:SpringBoot项目默认不支持将静态资源和模板(web页面)放到webapp目录,但是个人感觉resources目录只放项目的配置更加简洁,所以就将web页面继续放到webapp目录了.

## 项目特点
1. 基于SpringBoot,简化了大量项目配置和maven依赖,让您更专注于业务开发,独特的分包方式,代码多而不乱。
2. 完善的日志记录体系，计划记录请求日志，和调用第三方服务日志，业务日志
3. controller层采用map + warpper方式的返回结果，返回给前端更为灵活的数据.
7. 防止XSS攻击,通过XssFilter类对所有的输入的非法字符串进行过滤以及替换。
8. 简单可用的代码生成
9. 控制器层统一的异常拦截机制
10. 请求参数利用hibernate-validator校验，更好的过滤请求参数。
11. logback日志异步

## 业务日志记录原理

待实现，异步记录，提高系统性能



## swagger api管理使用说明
swagger会管理所有包含@ApiOperation注解的控制器方法，同时，可利用@ApiImplicitParams注解标记接口中的参数，具体用法请参考CodeController类中的用法。
```
 @ApiOperation("生成代码")
 @ApiImplicitParams({
         @ApiImplicitParam(name = "moduleName", value = "模块名称", required = true, dataType = "String"),
         @ApiImplicitParam(name = "bizChName", value = "业务名称", required = true, dataType = "String"),
         @ApiImplicitParam(name = "bizEnName", value = "业务英文名称", required = true, dataType = "String"),
         @ApiImplicitParam(name = "path", value = "项目生成类路径", required = true, dataType = "String")
 })
 @RequestMapping(value = "/generate", method = RequestMethod.POST)
```
## 2022/03/08 新增组件

- 多级缓存  cache-spring-boot-starter

- 测试

测试类型-短链的应用  TpShorturlInfoServiceImpl

