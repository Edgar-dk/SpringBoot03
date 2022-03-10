package com.sias.boot;

import com.sias.boot.bean.User;
import com.sias.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@Slf4j
class DemoApplicationTests {


    /*1.把这个对象注入进来，就可以去使用*/
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from blog", long.class);
        log.info("总共有:{}",aLong);
    }





    /*2.Mybatis-plus测试，按照id来查询*/
    @Autowired
    UserMapper userMapper;
    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1);
        log.info("查询的信息是：{}",user);
    }

}
