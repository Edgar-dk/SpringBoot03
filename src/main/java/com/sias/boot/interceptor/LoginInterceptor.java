package com.sias.boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Edgar
 * @create 2022-03-03 10:44
 */

/*作用是用于个个方法之前和之后的登陆检查，需要实现一个接口
* 一：需要配置好这个拦截器拦截那些请求
*     把这些配置放在容器中进行管理（好对这些请求进行拦截）*/
    @Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /*1.方法执行之前拦截*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();
        log.info("preHandle的拦截路径*",requestURI);
        /*01.为什么设置密码，可能是因为在进入主页面的时候，需要拦截器主页面的方法，先验证密码是否正确
        * 密码正确的话，允许进入，不正确的话会在登陆页面显示信息，可以能是在拦截器，登陆密码之后，在
        * 去执行，登陆页面，把密码给登陆页面，在和服务器存储的密码匹配*/
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            return true;
        }

        /*02.下面的方法，是直接调用request的方法，去设置一个值映射到浏览器页面上，msg是
        *    一样的，只是内容是不一样的,若是直接访问主页面，下面的内容是显示在登陆页面的
        *    */
        request.setAttribute("msg","请先登陆11111111");
        /*03.把页面的地址转发到这个方法（原理利用的是原生的servlet）*/
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    /*2.方法执行之后拦截*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行");
    }


    /*3.页面渲染之后执行*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("after执行");
    }

}
