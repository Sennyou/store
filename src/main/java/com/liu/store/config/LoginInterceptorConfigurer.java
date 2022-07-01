package com.liu.store.config;

import com.liu.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
//    将自定义的拦截器进行注册
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        //注册黑名单
        registration.addPathPatterns("/**");
        //注册白名单,这个方法既可以传入这样一个一个字符串,也可以传入一个List数组
        //这个起始目录是从static目录下开始的
        registration.excludePathPatterns("/web/login.html","/web/index.html","/web/register.html",
                "/web/**/*.css","/web/**.js","/web/**/*.js","/web/image/**","//user/reg","//user/login");
    }
}
