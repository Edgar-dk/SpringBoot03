package com.sias.boot.mapper;

import com.sias.boot.bean.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Edgar
 * @create 2022-03-06 15:06
 * @faction: 这是一个接口
 */
//这是一个Mapper接口，具体的实现方法，需要在配置文件中去写
@Mapper
public interface AccountMapper {
    public Account getAccount(Long id);

}
