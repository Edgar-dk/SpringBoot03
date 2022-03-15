package com.sias.boot;

import com.sias.boot.bean.User;
import com.sias.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
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



    /*3.idea整合Redis的使用
    *   服务器：使用的是远程的阿里云
    *       注意：这个地方，还没有做出具体的实例，还是需要观看视频的
    *            使用的话，需要去创建一个服务器，没有创建，是不可以使用的*/
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//    @Test
//    public void TestRedis(){
//        ValueOperations<String, String> value = stringRedisTemplate.opsForValue();
//        value.set("hello","你好，Redis看见你了");
//        String hello = value.get("hello");
//        System.out.println(hello);
//    }

}
