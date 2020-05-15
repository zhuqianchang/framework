# （一）从零搭建后端框架——构建SpringBoot项目

## 什么是Spring Boot
Spring Boot是由Pivotal团队提供的全新框架。可以轻松地创建独立的、生产级的、基于Spring的应用程序，并能尽可能地减少配置文件。

构建Spring Boot项目有多种方式，下面介绍最常用的两种方式。

### 使用Spring Initializr构建项目
* 1.访问[https://start.spring.io/](https://start.spring.io/)
* 2.选择Maven Project、Java、Spring Boot版本以及一些工程基本信息，参考下图所示：
<div align="left">
    <img src="https://user-gold-cdn.xitu.io/2020/5/15/172177287f13b50e?w=1523&h=883&f=png&s=79493" width="800" alt="构建项目"/>
</div>

* 3.点击GENERATE下载项目压缩包
* 4.解压后，使用Idea导入项目，File -> New -> Model from Existing Source... -> 选择解压后的文件夹即可

### 使用Idea开发工具构建项目
* 1.选择File -> New -> Project... 弹出构建项目的框
* 2.选择Spring Initializr，点击Next
* 3.填写工程基本信息之后，点击Next
* 4.选择依赖的模块之后，点击Next
* 5.填写工程名和存储目录，点击Finish即可

### 项目结构
<div align="left">
    <img src="https://user-gold-cdn.xitu.io/2020/5/15/172177c0ee7cd984?w=370&h=467&f=png&s=19679" alt="项目结构"/>
</div>

构建项目后可以看到，基础结构共三个文件夹：

* src/main/java 项目源代码
* src/main/resources 配置文件
* src/test/java 单元测试代码

## 编写Web接口
项目构建后，我们来开发简单的后端Web接口

### 引入Web模块
在构建项目时，我们已经引用了Web模块。如果没用引用，可以手动在pom.xml添加引用。
```xml
<!-- web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### 编写controller
```java
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "Hello World";
    }
}
```
* @RestController注解，相当于@Controller和@ResponseBody的结合，用于返回json数据。
* @GetMapping("/index")，相当于@RequestMapping(value = "/index", method = RequestMethod.GET)，用于接收GET请求

## 启动项目
Spring Boot内嵌Tomcat，可以直接启动：
<div align="left">
    <img src="https://user-gold-cdn.xitu.io/2020/5/15/1721772fec486c0d?w=672&h=225&f=png&s=22313" alt="项目启动"/>
</div>

@SpringBootApplication注解是下面三个注解的总和
* @Configuration 用于定义一个配置类
* @EnableAutoConfiguration Spring Boot会自动根据你jar包的依赖来自动配置项目
* @ComponentScan 指定Spring自动扫描并且装入bean容器的包路径

启动完成后，可以在控制台看到打印信息：

<div align="left">
    <img src="https://user-gold-cdn.xitu.io/2020/5/15/172177328666c281?w=1412&h=311&f=png&s=61518" alt="启动日志"/>
</div>

## 测试接口
在浏览器上访问：[http://localhost:8080/index](http://localhost:8080/index)。页面返回的信息如下：

<div align="left">
    <img src="https://user-gold-cdn.xitu.io/2020/5/15/172177357cb73dbe?w=643&h=235&f=png&s=13633" alt="访问接口"/>
</div>

至此，我们成功的看到了返回的信息。虽然它返回的信息很简单，但我们成功的访问了服务器并获得了数据。

我们其实只是引用了Web模块，并编写了一个controller。这证明了Spring Boot极大的简化了我们的开发。

## 总结
使用 Spring Boot 可以非常方便、快速搭建项目，使我们不用关心框架之间的兼容性，适用版本等各种问题，我们想使用任何东西，仅仅添加一个配置就可以，使用 Spring Boot 极大的提升了开发效率。
