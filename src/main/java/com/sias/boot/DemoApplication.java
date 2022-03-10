package com.sias.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
//@MapperScan("com.sias.boot.mapper")//可以不用给每一个接口标注mapper，直接一个总的标注即可
@ServletComponentScan(basePackages = "com.sias.boot")//自动的把 创建好的servlet扫描进来
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
