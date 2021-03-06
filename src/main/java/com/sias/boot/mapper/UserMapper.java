package com.sias.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sias.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Edgar
 * @create 2022-03-07 19:07
 * @faction:
 */
@Mapper

/*为什么这个接口要继承这类呢，原因是，这是继承的Mybatis-plus中的类，里面直接
* 写好了，基本的增删改查的方法，可以直接使用里面写好的方法，如果说查询的方式是比较麻烦的
* 还是需要自己写，并且继承了这个类，XML配置文件也是不需要写的，那么里面的泛型是什么
* 里面是类型，就是可以操作User类型的数据，就是可以把数据库里面的数据封装成User类型*/
public interface UserMapper extends BaseMapper<User> {

    /*1.想要使用里面的方法，只需要在测试方法中，直接注入这个类，就可以
    * 使用里面的方法(为什么可以使用里面的方法呢，原因是，直接注入进来，相当是，创建了对象，
    * 可以直接对象点方法来调用，具体的为什么，我也不知道，这是底层东西，人不理解)是相当的方便的*/


    /*2.重要的一步是，连基本的查询语句都不写*/


    /*3.查询数据库的发展过程
    *   01.javaWeb模式下的Servlet下操作数据库
    *       需要写大量的代码
    *   02.Spring中的JdbcTamlpate
    *       只需要(个人写的比较混乱，自己都不想看)
    *   03.Mybatis方式
    *      001.基本的方式
    *          先写接口（接口中可以注解的形式操作数据库），写一个配置文件继承这个接口
    *          里面写操作数据库的方法，在去创建工厂，在工厂里面，加载config.xml(就是连接数据库的地址)，
    *          在config.xml中,里面在连接好具体操作数据库的配置文件,最后在测试方法中加入创建好的
    *          工厂对象，把操作数据库的配置文件再入进来，在使用接口去调用，里面的方法，
    *          这个时候可能会理解成，接口里面的方法，不是没有写方法体吗，不是调用接口里面的方法
    *          是调用实现这接口的配置文件的方法，这样，随着一大串的文件加载，就可以操作数据库里面的数据了
    *      002.SpringBoot的方式
    *          只需写一个接口（可以注解），在写一个配置文件（继承这个接口），这个config.xml文件有没有无所谓
    *          因为在这个文件中配置的话（写地址信息），写的方式太麻烦，这个时候，是可以在yaml文件中写的
    *          最后，在来一个测试类，直接注入这个写好操作数据库的类（文件也可以），直接调用写好的方法，
    *          也可以，在Service层转一下，在页面展示的地方注入Service，在去调用写好的方法
    *
    *   04.Mybatis-plus方式
    *      简单粗暴
    *      写好yaml中数据库的地址，以及用户和密码（还有其他的信息），在写一个接口，继承一个方法，泛型的地方写上要封装数据的名字，
    *      继承的这个方法里直接写好了操作数据库的代码，在测试的方法中，注入接口，然后调用里面的方法，
    *      传递参数，然后直接测试*/
}
