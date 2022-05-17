package com.example.admin.config;

import com.example.admin.interceptor.LoginInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 1.编写拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中(实现WebMvcConfigurer的addInterceptors)
 * 3.指定拦截规则(如果拦截所有静态资源也会被拦截)
 *
 * EnableWebMvc:全面接管
 * 1.静态资源，视图解析器，欢迎页等全部失效
 */

//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * 定义静态资源行为
     * 访问aa路径下的所有请求都跳转至classpath:/static/匹配
     */
/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/aa/**").addResourceLocations("classpath:/static/");
    }*/
/*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //静态资源也会被拦截
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");
    }*/

/*    @Bean
    public WebMvcRegistrations webMvcRegistrations(){
        return new WebMvcRegistrations(){
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return WebMvcRegistrations.super.getRequestMappingHandlerMapping();
            }
        };
    }*/
}
