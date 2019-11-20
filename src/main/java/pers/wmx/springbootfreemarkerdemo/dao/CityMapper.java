package pers.wmx.springbootfreemarkerdemo.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pers.wmx.springbootfreemarkerdemo.entity.City;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("select * from  city where id = #{id}")
    public City findById(Long id);

    @Select("select * from  city")
    public List<City> findCityList();

}
