package com.student.student_management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.student.student_management.middleware.StudentInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private StudentInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/students/**"); 
    }
}