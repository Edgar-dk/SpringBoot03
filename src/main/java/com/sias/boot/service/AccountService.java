package com.sias.boot.service;

import com.sias.boot.bean.Account;
import com.sias.boot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Edgar
 * @create 2022-03-06 15:40
 * @faction: 业务逻辑组件：就是作为数据库和页面直接的控制者
 */
@Service
public class AccountService {

    /*1.把创建好的接口注入进来，可以使用里面的方法（在当前类下面使用），至于为什么可以使用：可能是把当前类导入进来之后
        就是创建好的对象，然后，对象点方法，就是调用一个方法
    *   有关里面的方法，是配置文件继承好内容，因为：不可能使用接口吧（没有具体的过程实现）*/
    @Autowired
    AccountMapper accountMapper;

    public Account getAccountById(Long id){
        return accountMapper.getAccount(id);
    }
}
