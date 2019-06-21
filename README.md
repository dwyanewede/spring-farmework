## spring-farmework基础框架及相关功能扩展

### com.sxs.demo.springfarmework
功能点：请求日志打印
该项目中采用了web mvc的组件装配特性，进行请求的拦截（包括请求的URL，Method和Params），是对日志打印的流程的实现

### com.sxs.demo.springfarmework.extend.redis
功能点：整合Redis实现秒杀功能
该项目整合Redis实现了分布式系统对秒杀功能的支持思想，主要是为了解决并发访问导致的数据一致性的问题
