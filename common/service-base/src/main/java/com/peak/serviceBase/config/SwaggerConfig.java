package com.peak.serviceBase.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName : SwaggerConfig
 * @Author : Administrator
 * @Date: 2023/03/10 12:42
 * @Description : Swagger配置
 */


//访问地址: 配置中心文档: http://localhost:9090/configurationCenterApi/swagger-ui.html#/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                //调用apiInfo方法,创建一个ApiInfo实例,
                // 里面是展示在文档页面信息内容
                .apiInfo(webApiInfo())
                .select()
                //过滤掉admin路径下的所有页面
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                //过滤掉所有error或error.*页面
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();

    }
    // api文档的详细信息
    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("配置中心接口测试")    //标题
                .description("本文档描述接口测试用例")  //描述
                .version("1.0")  //版本
                .contact(new Contact("java", "http://baidu.com", "123@qq.com"))
                .build();
    }


}
