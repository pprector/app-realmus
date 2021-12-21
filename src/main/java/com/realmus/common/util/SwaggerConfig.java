package com.realmus.common.util;

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
 * @author hkpeng
 * @date 2021/12/21 - 16:20
 */
@Configuration
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket( ){

        return  new Docket(DocumentationType.SWAGGER_2)
                .groupName("realmus_API")
                .select()
                //.paths(PathSelectors.ant("/hello/**"))
                .build();//构建者模式
    }
}
