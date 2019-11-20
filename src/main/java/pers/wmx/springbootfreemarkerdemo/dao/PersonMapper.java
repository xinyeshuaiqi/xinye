package pers.wmx.springbootfreemarkerdemo.dao;

import org.apache.ibatis.annotations.*;
import pers.wmx.springbootfreemarkerdemo.entity.Person;

import java.util.List;

/**
 * @author wmx
 * @date 2019-11-20
 */
@Mapper
public interface PersonMapper {

    @Insert("insert into person(name,age) value(#{name},#{age})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(Person person);

    @Insert({
            "<script>",
            "insert into person(name,age) ",
            "values ",
            "<foreach collection='personList' item='item' index='index' separator=','>",
            "(#{item.name}, #{item.age})",
            "</foreach>",
            "</script>"
    })
    int insertBatch(@Param("personList") List<Person> personList);

    @Update({
            "update person",
            "set name = #{name}, age = #{age}",
            "where id = #{id}",
    })
    int update(Person person);

    @Delete("delete from person where id = #{id}")
    int delete(Integer id);

    @Select("select * from  person")
    List<Person> select();
}
