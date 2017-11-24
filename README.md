# SpringBoot框架搭建和学习

1：实现helloword

2：实现全局异常捕捉

3：实现定时器功能

4：使用Druid和监控配置
访问地址http://127.0.0.1:8082/boot/druid2/index.html,http://127.0.0.1:8082/boot/druid/index.html


5：集成Swagger
访问地址：http://127.0.0.1:8082/boot/swagger-ui.html

6:集成redis集群,集成redis,不能同时使用

7:整合mybaits

8:分布式Session状态保存Redis
在使用spring boot做负载均衡的时候，多个app之间的session要保持一致，这样负载到不同的app时候，在一个app登录之后，而访问到另外一台服务器的时候，session丢失

9:集成shiro实现用户权限管理