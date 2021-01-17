package com.microservice.cyz.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 崔耀中
 * @since 2020-09-09
 */
@Configuration("knife4jConfig")
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    @Value("${spring.application.name:}")
    private String name;

//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Spring Boot实战")
//                .description("Spring Boot实战的RESTFul接口文档说明")
//                .version("1.0").build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(name).version("v2.0").build();
    }

    @Bean(value = "api1")
    public Docket api1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("用户中心")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.microservice.cyz.user"))
                .paths(PathSelectors.regex("^(?!auth).*$"))
                .build()
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts())
                .apiInfo(apiInfo())
                ;
    }

}
