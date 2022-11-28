package com.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
*   映射图片
* */
@Configuration
public class ImageUploadConfig implements WebMvcConfigurer {
//
    @Value("${file.uploadPath}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //添加资源映射规则，默认的前缀是：http://localhost:port
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath );
        //这里就相等于设，http://localhost:port/file/upload/**
        // ** 默认掉用本地的 E:/图片保存/upload/**
    }
}