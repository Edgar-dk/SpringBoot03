package com.sias.boot.config;

import com.sias.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Edgar
 * @create 2022-03-03 10:52
 */
@Configuration//可以理解成是一个Bean管理（来管理对象的创建和属性的赋值，以及其他的东西）
public class AdminWebConfig implements WebMvcConfigurer {




    /*1.添加拦截器
    *   只是添加了拦截器，还没有加入定义好的拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())//把定义好的拦截器，加入进来
                .addPathPatterns("/**")//表示拦截所有的请求,包括静态请求
                /*放行的地址,至于为什么这样写吗，原因是，在访问main的时候，
                里面也有子页面的资源，上面的拦截请求，也把静态资源拦截了，所以主页面渲染的时候
                会出现问题，拦截器拦截的是下面通过的方法（三种方法执行之前，之后）*/
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
