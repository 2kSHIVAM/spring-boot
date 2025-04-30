package com.learning.annotations.Annotations.FiltersAndInterceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    MyInterceptor1 myInterceptor1;

    @Autowired
    MyInterceptor2 myInterceptor2;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(myInterceptor1)
                .addPathPatterns("/api/*")
                .excludePathPatterns("/api/deleteUser");

        registry.addInterceptor(myInterceptor2)
                .addPathPatterns("/api/*")
                .excludePathPatterns("/api/deleteUser");
    }

    @Bean
    public FilterRegistrationBean<MyFilter1> myFilter1(){
        FilterRegistrationBean<MyFilter1> filter1FilterRegistrationBean = new FilterRegistrationBean<>();
        filter1FilterRegistrationBean.setFilter(new MyFilter1());
        filter1FilterRegistrationBean.addUrlPatterns("/*");
        filter1FilterRegistrationBean.setOrder(1);
        return filter1FilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> myFilter2(){
        FilterRegistrationBean<MyFilter2> filter2FilterRegistrationBean = new FilterRegistrationBean<>();
        filter2FilterRegistrationBean.setFilter(new MyFilter2());
        filter2FilterRegistrationBean.addUrlPatterns("/*");
        filter2FilterRegistrationBean.setOrder(2);
        return filter2FilterRegistrationBean;
    }
}
