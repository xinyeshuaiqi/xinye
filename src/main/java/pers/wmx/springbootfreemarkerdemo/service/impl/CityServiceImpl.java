package pers.wmx.springbootfreemarkerdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.wmx.springbootfreemarkerdemo.dao.CityMapper;
import pers.wmx.springbootfreemarkerdemo.domain.City;
import pers.wmx.springbootfreemarkerdemo.service.ICityService;

import java.util.List;

/**
 * @author: wangmingxin02
 * @create: 2019-03-26
 **/
@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    CityMapper cityMapper;


    @Override
    public City findById(Long id) {
        return cityMapper.findById(id);
    }

    @Override
    public List<City> findCityList() {
        return cityMapper.findCityList();
    }
}
