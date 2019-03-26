package pers.wmx.springbootfreemarkerdemo.service;

import pers.wmx.springbootfreemarkerdemo.domain.City;

import java.util.List;

public interface ICityService {

    public City findById(Long id);

    public List<City> findCityList();

}
