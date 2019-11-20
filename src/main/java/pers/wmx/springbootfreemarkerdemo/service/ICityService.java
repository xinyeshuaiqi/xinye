package pers.wmx.springbootfreemarkerdemo.service;

import pers.wmx.springbootfreemarkerdemo.entity.City;

import java.util.List;

public interface ICityService {

    public City findById(Long id);

    public List<City> findCityList();

}
