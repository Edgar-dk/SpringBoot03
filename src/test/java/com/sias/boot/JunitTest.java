package com.sias.boot;

import com.sias.boot.bean.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Edgar
 * @create 2022-03-15 10:12
 * @faction:  单元测试
 */
@DisplayName("junit5的单元测试")
public class JunitTest {

    /*1.DisplayName这个注解的目的是，标注这个方法，或者是这个类，正在
    *   执行*/
    @DisplayName("测试displayname注解1")
    @Test
    public void testDisplayName1(){
        System.out.println(1);
    }
    @Disabled//表示当前的方法，已失效
    @DisplayName("测试displayname注解2")
    @Test
    public void testDisplayName2(){
        System.out.println(1);
    }




    /*2.每一个方法执行前后执行了*/
    @BeforeEach
    public void  BeforeEach(){
        System.out.println("每一个方法执行之前，就去执行了这个方法");
    }
    @AfterEach
    public void  AfterEach(){
        System.out.println("每一个方法执行之后去执行了");
    }




    /*3.所有方法执行完之后在去执行
    *   需要在类上点击执行，才可以执行全部的方法，进而才可以执行下面的*/
    @BeforeAll
    public static void  BeforeAll(){
        System.out.println("所有方法执行之前，执行了这个方法");
    }
    @AfterAll
    public static void  AfterAll(){
        System.out.println("所有方法执行完之后，在去执行这个方法");
    }



    /*4.这个测试方法执行多次*/
    @Test
    @RepeatedTest(10)
    public void RepeatedTest(){
        System.out.println("43254235235434534");
    }


    /*5.超过规定的时间就失效
    *   注意：最前面规定的数是超过这个时间就失效，方法中的数是，睡眠的时间
    *   从执行到执行里面的方法，这是一个结束，但是这个方法执行的时间超过了规定的时间
    *   就抛出了异常，原因是规定时间到了*/
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    public void Timeout() throws InterruptedException {
        Thread.sleep(530);
        System.out.println("这个方法失效了吗。。。。。。。其实我也不知道");
    }


    /*6.断言机制的测试*/
    @Test
    @DisplayName("测试断言")
    public void testSimpleAssertions(){
//        int test = calTest(1, 2);
        /*01.判断数值是否相等第一个是期望值，第二个是真实值：把数据带入方法中，是可以测试出真实值的
        *    注意：第一个不成里的话，后面的所有方法都不会执行*/
        assertEquals(5,calTest(1,4),"业务逻辑计算失败");
        Object o = new Object();
        Object o1 = new Object();
        /*02.判断两个对象是不是一样的*/
        assertSame(o,o1,"两个对象不一样");

    }
    public int calTest(int i,int j){
        return i+j;
    }





    /*7.数组的形式去测试断言*/
    @Test
    @DisplayName("7.数组的形式去测试断言")
    public void  TestArray(){
        /*01.数据的形式去测试断言
        *    会直接和第一个比较。不想等的话，在去打印出后面的内容*/
        assertArrayEquals(new  int[]{1,2}, new  int[]{2,3},"数组内容不想等");
        /*02.总结：创建对象的三中方式，每一次创建的方式不一样，导致的作用也是不一样的
        *    第一种：直接把这个类拿过来，去创建一个对象，然后在去调用相应的方法
        *    目的：简单粗暴*/
        User user = new User();
        user.toString();
        /*第二种：参数中去创建对象
        *        这个参数中是，在方法里面的参数中
        *        目的是，直接往里面添加数据*/
//        user.toString(new City(32,"张三","李四","上海"));
        /*第三种：方法的参数中去创建对象,只是这种创建的方式不一样
        *        直接把类的名字填写进去，就相当于创建了对象
        *        目的：可以直接在下面调用相应的方法*/
        /* public void cat(Model model){
            model.addAttribute();

        }*/


    }



    /*8.组合断言：只有所有的满足之后才可以执行*/
    @Test
    @DisplayName("8.组合断言")
    public void all(){
        assertAll("test",
                ()->assertTrue(true && true ,"结果不是true"),
                ()->assertEquals(1,2,"结果不是"));
    }

    /*9.前置的条件测试*/
    @Test
    @DisplayName("前置测试")
    public void Beforetest(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("12123321");
    }



    /*10.参数化测试
    *    就是使用各种参数，去测试一个方法（一个项目）,看看那个地方可能会出现问题*/
    @ParameterizedTest
    @DisplayName("10.参数化测试")
    /*01.来源的地址，可以是里面自定义的，也可以是来自其他方法的内容*/
    @ValueSource( ints = {1,2,3,4,5})
    public void ParameterizedTest(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("10.参数化测试")
    /*01.来源的地址，可以是里面自定义的，也可以是来自其他方法的内容*/
    @MethodSource( "ParameterizedTest2")
    public void ParameterizedTest1(String  i){
        System.out.println(i);
    }
     static Stream<String> ParameterizedTest2(){
       return Stream.of("zjhand","dhshd","dhsihdis");
    }

}
