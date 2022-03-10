package com.sias.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edgar
 * @create 2022-03-01 20:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("")//如果说数据库中表的名字发生改变，可以使用当前注解，表示真正的名字
public class User {



    /*1.表示的是这个属性在表中，不存在*/
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;


    //以下是操作Mybatis-plus的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
