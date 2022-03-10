package com.sias.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author Edgar
 * @create 2022-03-05 16:52
 * @faction:  自定义数据源
 */
@Deprecated//表示当前的配置类信息没有 作用了，为什么要注释掉这个类呢，原因是，下面的是自己配置的信息
/*配置的是数据库和业务逻辑层之间的控制者，是用来拦截数据，和页面管理的，机子配置的，手动的话，太麻烦，
* 可以直接在yaml中写就可以了，这就是注释掉这个的原因*/
//@Configuration//配置类
public class MyDataSourceConfig {


    /*1.自己配置数据源（可以在具体的地方加上，基本的数据和数据库连接）
    *   自己配置的话，SpringBoot本身的话，就不去配置数据源*/

    /*这个注解是，和yaml的进行绑定，使得下面的代码加在那个配置文件中,同时也是可以直接在
    * 配置文件中，直接写有关的信息的*/
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        /*01.开启监控功能和防火墙*/
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }


    /*2.druid的拦截（监控页功能，就是登陆功能）
        就是在和数据库交互的时候，数据都会被这个页面监控，监控的是页面（注入问题）
    *   其实在创建第一个对象的时候，用的资源是导入进来的，不需要自己去写，
    *   在过程中，直接用写好的，然后把写的过程在放到拦截的地址括号中，前面是响应的过程，后面是拦截的地址*/
    @Bean
    public ServletRegistrationBean StaViewServletL(){
        /*01.new写好的过程*/
        StatViewServlet viewServlet = new StatViewServlet();
        /*02.把过程和地址，写进一个对象中，可以直接调用去使用*/
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(viewServlet,/*过程写进来*/"/druid/*"/*后面一个是拦截的地址*/);
        /*03.给这个登陆页面添加账户和密码*/
        bean.addInitParameter("loginUsername","a");
        bean.addInitParameter("loginPassword","1");
        return bean;
    }



    /*3.监控Web应用页*/
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> bean1 = new FilterRegistrationBean<>(webStatFilter);
        /*01.拦截的地址*/
        bean1.setUrlPatterns(Arrays.asList("/*"));
        /*02.排除的地址*/
        bean1.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.css,*.ico,/druid/*");
        return bean1;
    }


}
