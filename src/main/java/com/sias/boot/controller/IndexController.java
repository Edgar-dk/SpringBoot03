package com.sias.boot.controller;

import com.sias.boot.bean.Account;
import com.sias.boot.bean.City;
import com.sias.boot.bean.User;
import com.sias.boot.service.AccountService;
import com.sias.boot.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Edgar
 * @create 2022-03-01 20:06
 */
/*这个是一个首页面跳转的页面，以及和数据库打交道的页面*/
@Controller
@Slf4j//打印日志输出
public class IndexController {

    /*1.登陆页面*/
    /*这是一个主程序入口（就是浏览器从这里登陆），登陆成功后，跳转到login（templates）
    * 地方，然后在根据里面的地址，在跳转，为什么在次的跳转呢，原因是，这只是一个要登陆的页面，还没有
    * 进入到主页面，所以需要从登陆的页面跳转到主页面（填写主页面的地址），这个时候又出现了一个问题
    * 就是在登陆到主页面之后，想要再次的刷新这个主页面，还需要再次发送一次post请求，而且地址栏
    * 还是登陆页面的地址，需要做出改变，就需要用重定向的方式，从登陆页面转到主页面，这个时候，地址栏中的
    * 地址也是主页面的地址，同时再次的刷新浏览器，不会在次的提交请求，而是刷新的当前的页面
    * 改变的办法是在；登陆页面即将要跳转到主页面的时候，写重定向到主页面*/
    @RequestMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }



    /*2.登陆判断页面*/
    @PostMapping("/login")
    public String main(User user , HttpSession session, Model model){
        log.info("main的方法执行");
        if (StringUtils.hasLength(user.getUserName()) && "1".equals(user.getPassword())){
            /*if中的条件成立的话，执行下面的语句，就是把密码存起来，存到user对象中，名字是loginUser*/
            session.setAttribute("loginUser","user");
            return "redirect:/main.html";
        }else {
            /*若是有一条不成功，在放回到登陆的页面*/
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
        /*返回的时候，用重定向，地址栏地址是主页面地址，可以多次刷新，不提交请求*/
    }

    /*3.进入主页面*/
    @GetMapping("/main.html")
    public String MainPage(HttpSession session, Model model) {
        /*虽然在登陆的页面上了判断的语句，下面的还是需要加上的，目的是为了防止直接访问
        * 主页面，然而在有了拦截器的功能之后，下面的就不需要加上判断了，直接在拦截器的
        * 地方拦截了所以除了放行的之外，访问有个要拦截的页面后，在根据条件返回到登陆页面，
        * 然后登陆页面在根据里面的条件，直接到主页面*/
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//            return "main";
//        } else {
//            model.addAttribute("msg", "请重新登陆");
//            return "login";
//        }
        return "main";
    }

    /*4.数据监控实例，就是看看能不能连接数据库*/
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/sql")
    @ResponseBody
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from blog", long.class);
        /*01.把产生的次数，打印出来*/
        return aLong.toString();
    }





    /*5.Mybatis测试，按照id来查询（数据显示在浏览器上）*/
    @Autowired
    AccountService accountService;
    @ResponseBody
    @GetMapping("/account")
    public Account getById(@RequestParam("id")/*接受来自浏览器和地址栏中的参数*/ Long id){
        return accountService.getAccountById(id);

    }


    /*6.注解的形式访问数据库，按照id来查询*/
    @Autowired
    CityService cityService;
    @ResponseBody
    @RequestMapping("/city")
    public City getCityById(Long id){
        City cityService = this.cityService.getCityService(id);
        return cityService;
    }



    /*7.插入数据，以city对象存储数据的方式插入进去（这个没有写post的页面数据，老师的是以软件的方式传输的）*/
    @ResponseBody
    @RequestMapping("/city1")//需要写表格传输数据，还没写
    public City getIndexInsert(City city){
        cityService.getCityById(city);
        return city;
    }
}
