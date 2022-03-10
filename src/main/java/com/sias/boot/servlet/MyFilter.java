package com.sias.boot.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Edgar
 * @create 2022-03-05 11:16
 * @faction: 原始方式过滤器
 */
//@WebFilter(urlPatterns = {"/css/*","/image/*"})//拦截的请求，一个*表示的是项目中的，拦截这个几个路径，其他的不拦截
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("正在工作");
    }

    @Override
    public void destroy() {
        log.info("销毁");
    }
}
