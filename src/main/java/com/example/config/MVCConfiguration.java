package com.example.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by pengtao on 2017/4/26.
 */
@Component
public class MVCConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private SwaggerConfigProperties scp;

    private static Properties props;

    public MVCConfiguration() {

        try {
            Resource resource = new ClassPathResource("/application.properties");//
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (scp.isEnable()) {
            registry.addResourceHandler("swagger-ui.html");
        }
    }

    @Bean
    public Docket createRestApi() {
        ApiInfo apiInfo = new ApiInfoBuilder().title(scp.getTitle())//大标题
            .description(scp.getDescription()).version(scp.getVersion())//版本
            .build();
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).enable(scp.isEnable())
            .useDefaultResponseMessages(false).select()
            .apis(RequestHandlerSelectors.basePackage(scp.getPackageScan())).build();
    }
}

