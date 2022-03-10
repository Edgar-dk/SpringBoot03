package com.sias.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sias.boot.bean.User;
import com.sias.boot.mapper.UserMapper;
import com.sias.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Edgar
 * @create 2022-03-07 20:41
 * @faction:
 */
@Service
/*UserServiceImpl操作的是UserMapper这张表（里面写好的方法）,返回的类型是User*/
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



    /*1.分析一下上面写的方式：第一点，UserServiceImpl这个类实现了UserService，就是实现了里面
    *   继承的方法，然而一旦实现，UserServiceImpl类，也是需要继承一个类的（具体的原因不知道），同时也就
    *   有了可以实现了面的方法，泛型里加的User是按照这个类来放回数据的
    *
    *
    * 2.反应一下个人的看法，本来一个UserMapper就可以了，实现了Mybatis-plus类，
    *   可以用里面的方法就可以了，然后在把这个类注入到首页面类中，可以直接调用里面的方法，
    *   然后在操作数据库等，不理解这中写法的原因所在，分析：按照企业的开发角度来理解，一个接口，一个实现类
    *   那么这个接口应该有一个就可以把，一个接口去继承Mybatis-plus中的BaseMapper类，然后一个类在去实现这个接口
    *   但是，一旦继承了这个接口，里面有很多的方法，不可能一下子全部写完，从而有了这一步，（可能是隐藏方法吧，个人理解）*/
}
