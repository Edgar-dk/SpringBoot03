package com.sias.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Edgar
 * @create 2022-03-05 11:33
 * @faction: 监听器，当项目一启动的时候，就会监听到
 */
//@WebListener
@Slf4j
public class WebServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("监听到项目初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("监听到项目初始化销毁");
    }
}
