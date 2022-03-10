package com.sias.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sias.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Edgar
 * @create 2022-03-07 20:42
 * @faction:
 */


//@Mapper
/*继承这个接口，之后，是对这个user进行的增删改查的操作，IService是一个顶级Service的类*/
public interface UserService extends IService<User> {
}
