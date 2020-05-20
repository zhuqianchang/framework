package com.zhuqc.framework.configuration;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置
 *
 * @author Zhu.Qianchang
 * @date 2020-05-18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // apis 指定生成API的扫描条件
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.any())
                // 扫描包
                //.apis(RequestHandlerSelectors.basePackage("com.zhuqc.framework.controller"))
                // paths 指定生成API的path
                .paths(PathSelectors.any())
                .build()
                // 文档信息
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("从零搭建后端框架")
                .description("API接口文档")
                .termsOfServiceUrl("https://github.com/zhuqianchang/framework")
                .contact(new Contact("zhuqianchang", "", ""))
                .version("0.0.1")
                .build();
    }
}
