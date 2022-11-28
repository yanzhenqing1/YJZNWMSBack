package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadFilePathConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //将所有/upload/** 访问都映射到classpath:/upload/ 目录下
        registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
    }

}
