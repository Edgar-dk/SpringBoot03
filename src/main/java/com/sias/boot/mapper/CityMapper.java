package com.sias.boot.mapper;

import com.sias.boot.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Edgar
 * @create 2022-03-07 12:55
 * @faction: 这是一个Mapper接口，注解的形式去查询
 */
@Mapper
public interface CityMapper {



    /*1.注解的形式去按照id来查询*/
    @Select("select * from city where id=#{id}")
    public City getCityById(Long id);


    public void insert(City city);
}
