# springcloud-alibaba  
# Nacos 

# 1.整体介绍

* **服务限流降级**：默认支持 WebServlet、WebFlux, OpenFeign、RestTemplate、Spring Cloud Gateway, Zuul, Dubbo 和 RocketMQ 限流降级功能的接入，可以在运行时通过控制台实时修改限流降级规则，还支持查看限流降级 Metrics 监控。
* **服务注册与发现**：适配 Spring Cloud 服务注册与发现标准，默认集成了 Ribbon 的支持。
* **分布式配置管理**：支持分布式系统中的外部化配置，配置更改时自动刷新。
* **消息驱动能力**：基于 Spring Cloud Stream 为微服务应用构建消息驱动能力。
* **分布式事务**：使用 @GlobalTransactional 注解， 高效并且对业务零侵入地解决分布式事务问题。。
* **阿里云对象存储**：阿里云提供的海量、安全、低成本、高可靠的云存储服务。支持在任何应用、任何时间、任何地点存储和访问任意类型的数据。
* **分布式任务调度**：提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。同时提供分布式的任务执行模型，如网格任务。网格任务支持海量子任务均匀分配到所有 Worker（schedulerx-client）上执行。
* **阿里云短信服务**：覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建客户触达通道。

## 组件

**[Sentinel](https://github.com/alibaba/Sentinel)**：把流量作为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。

**[Nacos](https://github.com/alibaba/Nacos)**：一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。

**[RocketMQ](https://rocketmq.apache.org/)**：一款开源的分布式消息系统，基于高可用分布式集群技术，提供低延时的、高可靠的消息发布与订阅服务。

**[Dubbo](https://github.com/apache/dubbo)**：Apache Dubbo™ 是一款高性能 Java RPC 框架。

**[Seata](https://github.com/seata/seata)**：阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案。

**[Alibaba Cloud ACM](https://www.aliyun.com/product/acm)**：一款在分布式架构环境中对应用配置进行集中管理和推送的应用配置中心产品。

**[Alibaba Cloud OSS](https://www.aliyun.com/product/oss)**: 阿里云对象存储服务（Object Storage Service，简称 OSS），是阿里云提供的海量、安全、低成本、高可靠的云存储服务。您可以在任何应用、任何时间、任何地点存储和访问任意类型的数据。

**[Alibaba Cloud SchedulerX](https://help.aliyun.com/document_detail/43136.html)**: 阿里中间件团队开发的一款分布式任务调度产品，提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。

**[Alibaba Cloud SMS](https://www.aliyun.com/product/sms)**: 覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建客户触达通道。

更多组件请参考 [Roadmap](https://github.com/alibaba/spring-cloud-alibaba/blob/master/Roadmap-zh.md)。

## 2.技术点
### 1.Nacos
[介绍](https://nacos.io/zh-cn/docs/quick-start.html)
```
服务注册中心[eureka,zookeeper,Consul]+配置中心[config]+sentinel[Hystrix]+[bus]

AP+CP
切换 curl -x POST '$NACOS_SERVER:8848/nacos/v1/ns/operator/switches?entry=serverMode&value=CP'

config --dataID-- ${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}

server:
  port: 83
spring:
  application:
    name: cloudalibaba-order-consumer
  cloud:
    nacos:
        #注册发现
      discovery:
        server-addr: localhost:8848
        #配置中心
      config:
        server-addr: localhost:8848
        file-extension: yaml
        #分类配置
        group: 分组
        namespace: 建的id
     
  #集群和集群化配置:
      properties配置：
      
      spring.datasource.platform=mysql
      db.num=1
      db.url.0=jdbc:mysql://127.0.0.1/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
      db.user=root
      db.password=mysql密码
      
      集群形式:  nginx 上一个VIP1111端口  --  ip:3333，ip:4444，ip:5555端口+mysql
        
       
```
### 2.Sentinel-- 分布式系统的流量防卫兵(类似hystrix)
[介绍](https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D)
```
导包:
<!--alibaba nacos-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
<!--config-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
<!--sentinel-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>
<!--sentinel 配置持久化进入nacos-->
<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>sentinel-datasource-nacos</artifactId>
</dependency>

配置:
spring:
  application:
    name: cloudalibaba-sentinel-service
  cloud:
    nacos:
      discovery:
          server-addr: localhost:8848
      config:
          server-addr: localhost:8848
          file-extension: yml
    sentinel:
      transport:
        #sentinel dashboard 地址
        dashboard: localhost:8080
        port: 8719
      #sentinel 配置持久化入nacos配置，like 'nacos', 'apollo', 'file', 'zookeeper'
      datasource:
        ds1:
          nacos:
            server-addr: localhost:8848
            dataId: ${spring.application.name}
            groupId: DEFAULT_GROUP
            data-type: json
            #流控规则
            rule-type: flow
      
@SentinelResoure --  @HystrixCommand

```
#### A.[流控规则](https://github.com/alibaba/Sentinel/wiki/%E6%B5%81%E9%87%8F%E6%8E%A7%E5%88%B6):
```
    针对来源:可对调用者进行限流，填写微服务名,默认default(不区分来源)
    QPS(每秒的请求数量),当该api的QPS达到阈值，进行限流
    线程数：当调用该api的线程数达到阈值,限流
流控模式：
    直接:api达到限流条件，限流
    关联:当关联的资源达到阈值，限流自己
    链路:只记录指定链路的流量(指定资源从入口进来的流量,如果达到阈值,进行限流)[api级别针对来源]
流控效果:
    快速失败，直接失败，抛异常 -- com.alibaba.csp.sentinel.slots.block.flow.controller.DefaultController
    
    Warm Up：根据codeFactor(冷加载因子,默认3),从阈值/codeFactor,经过预热时长，才达到预设的QPS阈值
    即{最开始的阈值为(设置的阈值数A/3);经过预热时长秒数后;变为真正的阈值A} 【秒杀预热常用】
    详细:com.alibaba.csp.sentinel.slots.block.flow.controller.WarmUpController
    
    排队等待: 匀速排队,让请求匀速通过，阈值类型必须设置为QPS,否则无效  -- 漏桶算法
    详细: com.alibaba.csp.sentinel.slots.block.flow.controller.RateLimiterController
```
#### B.[降级规则:](https://github.com/alibaba/Sentinel/wiki/%E7%86%94%E6%96%AD%E9%99%8D%E7%BA%A7)
```
RT(平均响应时间，秒级)
平均响应时间 超出阈值 且 QPS>=5.
窗口器后关闭断路器
RT最大4900(更大通过-Dcsp.sentinel.statistic.max.rt=XXXX)

Sentinel 断路器没有半开状态

异常比例(秒级)
QPS>=5 且 异常比例(秒级统计)超过阈值时，触发降级，时间窗口期结束关闭降级

异常比例(分钟级)
异常比例(分钟级统计)超过阈值时，触发降级，时间窗口期结束关闭降级

熔断降级默认行为抛出DegradeException

```

#### C.[热点规则](https://github.com/alibaba/Sentinel/wiki/%E7%83%AD%E7%82%B9%E5%8F%82%E6%95%B0%E9%99%90%E6%B5%81):

```
com.alibaba.csp.sentinel.slots.block.BlockException
@SentinelResource主管 配置出错,运行时异常该走异常还是走异常

```
#### D.[系统规则](https://github.com/alibaba/Sentinel/wiki/%E7%B3%BB%E7%BB%9F%E8%87%AA%E9%80%82%E5%BA%94%E9%99%90%E6%B5%81)
```
Sentinel 系统自适应限流从整体维度对应用入口流量进行控制，
结合应用的 Load、CPU 使用率、总体平均 RT、入口 QPS 和并发线程数等几个维度的监控指标，通过自适应的流控策略，
让系统的入口流量和系统的负载达到一个平衡，让系统尽可能跑在最大吞吐量的同时保证系统整体的稳定性。
```
#### E. @SentinelResource
```
全局统一兜底:

CustomBlockHandler类 和 CustomFallbackHandler类

@GetMapping("/test_fallback_block")
@SentinelResource(value = "fallback", blockHandlerClass = CustomBlockHandler.class, blockHandler = "block_method2"
,fallbackClass = CustomFallbackHandler.class,defaultFallback = "defaultFallbackMethod")
public String byFallbackBlock(@RequestParam(value = "id", required = false) Integer id) {
    if (id == 3) {
        throw new RuntimeException();
    }
    if (id > 3) {
        throw new NullPointerException();
    }
    return "测试blockHandler和fallback";
}
#A.sentinel流控QPS设置阈值5,每秒请求超过5次流控..负责sentinel配置违规 
public class CustomBlockHandler {
    #必须为public 静态方法
    有blockHandler[参数类型一致+BlockException e]
    public static String fallback_method(BlockException e) {
        return "系统级别兜底1";
    }
}
#B.id>=3 报错(除了exceptionsToIgnore指定的异常之外)..降级 
public class CustomFallbackHandler {
    #必须为public 静态方法
    有 defaultFallback 和fallback[参数类型一致+Throwable e]
    public static String defaultFallbackMethod() {
        return "系统报错兜底1";
    }
}
同时sentinel配置触发和报错,sentinel配置触发优先

核心原理:
try catch final--Sphu定义资源,Trace定义统计，ContextUtil定义上下文

```

#### F. 服务熔断 *
```
#激活 Feign 支持
feign:
  sentinel:
    enabled: true

```
#### G.持久化
```

<!--sentinel-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>
<!--sentinel 配置持久化进入nacos-->
<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>sentinel-datasource-nacos</artifactId>
</dependency>

1.
spring:
  cloud:
    sentinel:
      transport:
        #sentinel dashboard 地址
        dashboard: localhost:8080
        port: 8719
      #sentinel 配置持久化入nacos配置，like 'nacos', 'apollo', 'file', 'zookeeper'
      datasource:
        ds1:
          nacos:
            server-addr: localhost:8848
            dataId: ${spring.application.name}
            groupId: DEFAULT_GROUP
            data-type: json
            #流控规则
            rule-type: flow
            
   2.json：
   
   [
     {
        "resource":"fallback",#资源名称
        "limitApp":"default",#来源应用
        "grade":1,#阈值类型,0-线程数，1-QPS
        "count":3,#单机阈值
        "strategy":0,#流控模式,直接，关联，链路
        "controlBehavior":0,#流控效果，快速失败，WarmUp,排队等待
        "clusterMode":false #是否集群
     }
   ]

```
    
    
    
    
    
    
    
    
    
    
    
    
    