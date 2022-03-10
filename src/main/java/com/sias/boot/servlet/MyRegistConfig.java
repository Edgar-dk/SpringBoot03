package com.sias.boot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Edgar
 * @create 2022-03-05 12:01
 * @faction: SpringBoot底层的一个方法，来添加三中组件，其实用到的是一个返回值的，最终的过程还是需要写的
 *           例如Servlet写的内容，以及拦截器方法的步骤，还有监听器的步骤
 */
@Configuration
public class MyRegistConfig {

    /*1.注入Servlet，
    *   原始的方式，还需要在配置文件中，添加各种的标价签，以及地址
    *   这种方式，直接使用一个注解，或者是一个放回类型ServletRegistrationBean
    *   就可以达到注入Servlet的目的，意思是，可以直接访问这个路径*/
    @Bean
    public ServletRegistrationBean MyServlet(){
        MyServlet myServlet = new MyServlet();
        return  new ServletRegistrationBean(myServlet,"/my","/my02");
    }
    /*2.过滤器，用于拦截请求的*/
    @Bean
    public FilterRegistrationBean MyFilter(){
        MyFilter myFilter = new MyFilter();
        /*01.拦截的是MyServlet请求中的地址*/
        return new FilterRegistrationBean(myFilter, MyServlet());
    }
    /*3.监听器的设置
    *   其实用到的还是创建好的步骤*/
    @Bean
    public ServletListenerRegistrationBean MyListener(){
        WebServletListener webServletListener = new WebServletListener();
        return new ServletListenerRegistrationBean(webServletListener);
    }
}
