package com.sias.boot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Edgar
 * @create 2022-03-05 10:48
 * @faction: 添加Servlet，就是添加地址，可以在浏览器中访问到，相当于一个RequestMapping添加的地址，但是
 *           两者也有不同的作用和功能
 */
//@WebServlet(urlPatterns = "/MyServlet")//这是一个访问路径
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*1.返回到浏览器，打印输出*/
        resp.getWriter().write("9856564265423554125");
    }
}
