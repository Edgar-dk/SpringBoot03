package com.sias.boot.service;

import com.sias.boot.bean.City;
import com.sias.boot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Edgar
 * @create 2022-03-07 12:58
 * @faction: 业务逻辑组件
 */
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;
    public City getCityService(Long id){
        City cityById = cityMapper.getCityById(id);
        return cityById;
    }

    public void getCityById(City city) {
        cityMapper.insert(city);
    }
}
