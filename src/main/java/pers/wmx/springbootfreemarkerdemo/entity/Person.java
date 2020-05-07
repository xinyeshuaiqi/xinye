package pers.wmx.springbootfreemarkerdemo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wmx
 * @date 2019-11-20
 */
public class Person {
    Integer id;

    String name;

    Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
