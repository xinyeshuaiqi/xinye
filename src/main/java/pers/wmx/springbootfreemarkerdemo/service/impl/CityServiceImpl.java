package pers.wmx.springbootfreemarkerdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import pers.wmx.springbootfreemarkerdemo.dao.CityMapper;
import pers.wmx.springbootfreemarkerdemo.entity.City;
import pers.wmx.springbootfreemarkerdemo.service.ICityService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author: wangmingxin02
 * @create: 2019-03-26
 **/
@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private CityMapper cityMapper;


    @Override
    public City findById(Long id) {
        return cityMapper.findById(id);
    }

    @Override
    public List<City> findCityList() {
        List<City> cityList = cityMapper.findCityList();
        stringRedisTemplate.opsForValue().set("city", JSON.toJSONString(cityList));
        return cityList;
    }

    @Override
    public Map<Long, City> batchGetCityInfo(Collection<Long> cityIds) {
        return null;
    }

}
