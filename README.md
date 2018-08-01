# springbootExample

#热部署参考
[springboot 在idea中实现热部署](https://blog.csdn.net/xusheng_Mr/article/details/78771746)
[springboot 热部署 idea版本（转）](https://www.cnblogs.com/a8457013/p/8065827.html)

#项目搭建参考
[Spring Boot【快速入门】](https://www.cnblogs.com/wmyskxz/p/9010832.html)

#进入druid无法监控sql问题

[spring boot 集成Druid后，sql监控不显示数据问题](https://blog.csdn.net/laozhong110/article/details/78980700)

需引入

```
 <dependency>
 			<groupId>log4j</groupId>
 			<artifactId>log4j</artifactId>
 			<version>1.2.16</version>
 			<scope>compile</scope>
 		</dependency>       
```
在配置文件中手动实例化DruidDataSource
详见DruidConfiguration配置

# QueryDSL与SpringDataJPA共同服务于SpringBoot
参考[QueryDSL与SpringDataJPA共同服务于SpringBoot](https://www.jianshu.com/p/7379173e1970)
