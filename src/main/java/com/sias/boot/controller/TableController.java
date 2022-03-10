package com.sias.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sias.boot.bean.User;
import com.sias.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author Edgar
 * @create 2022-03-02 14:26
 */
@Controller
public class TableController {


    /*1.访问主页面里面的其他字页面，当然下面的还没有判断是否登陆的状态，直接访问这个页面的地址是
    * 可以的，但是想要点击主页面里面的子页面访问，是不可以的，想要实现通过点击主页面进入子页面的，
    * 这种功能的话，需要下面的代码，起到一定的作用
    *
    * 注意:这种从主页面跳转到子页面的方式，是通过，在公共页面的设置，然后把公共的部分导入主页面，在加载
    *     的时候，可以点击子页面，从而实现跳转的功能*/
    @GetMapping("/basic_table")
    public String basic_table(){

        /*01.前面为什么加上了table，原因是当前的页面在当前的文件夹中，需要具体的地址，只是
        *    在具体的地址话，底层话帮助我们写好，只需要写上，自己加上的文件夹地址即可*/
        return "table/basic_table";
    }




    /*2.主页面跳转子页面+Mybatis-plus操作数据库展示页面数据*/

    @Autowired
    UserService userService;
//    @ResponseBody
    @RequestMapping("/dynamic_table")
    public String dynamic_table(/*第一个注解，从数据库中接收数据pn是当前页，defaultValue：如果没有取到当前也，从第一页开始*/
                                @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                Model model){
//        List<User> user1 = Arrays.asList(new User("张三", "11111"),
//                new User("李四", "22222"),
//                new User("王五", "33333"));
//        model.addAttribute("user2","user1");

        /*01.过来的数据被封装到User一个一个的被封装进去的，因为有很多数据，以集合的形式，
        *    数据进去之后，在以model的形式展示在页面上，至于怎么展示的，就是把数据传递到页面的代码
        *    上展示，那么，就需要设置一个作用域，可以在两个页面之间做出请求和共享，下面的就是，数据放在User中
        *    但是这个名字，是可以直接传递进model的，然后在给传递的数据起一个名字，在把这个名字放到页面中，就可以显示了*/
//        List<User> list = userService.list();
//        model.addAttribute("users",list);

        /*02.分页查询数据
             分页，new page泛型里面的User是对user进行分页,后面的数据，第一个是
        *    当前页码，后面的是当前页上的数据的个数，但是这样写的话，是不规范，原因：是从数据库中拿来的数据
        *    在这里反而写死了，应该按照数据库中的来，所以下面的应该是一个变量，就是点击一个页码，从数据库
        *    中传递一个*/
        Page<User> userPage = new Page<>(pn, 2);


        /*03.分页查询结果
             就是把查询数据进行细分一下，获取一下里面的也是，和总数，然后把获取的写在展示页面代码中，显示在页面上
             第一个参数，获取分页，以及一页上数据个数，第二个是，查询的条件*/
        Page<User> page = userService.page(userPage, null);

        /*04.第一个是第几页，第二个是总也数，第三个是总记录,第四个是真正查出来的数据进行遍历
        *    这是根据数据，细分的形式看看里面有哪几种（页数，总数....）*/
        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getTotal();
        List<User> records = page.getRecords();
        model.addAttribute("page",page);
        return "table/dynamic_table";
    }





    /*3.其他页面的跳转地址*/
    @RequestMapping("/responsive_table")
    public String  responsive_table(){
        return "table/responsive_table";
    }
    @RequestMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
