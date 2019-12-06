package pers.wmx.springbootfreemarkerdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.wmx.springbootfreemarkerdemo.dao.PersonMapper;
import pers.wmx.springbootfreemarkerdemo.entity.Person;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootFreemarkerDemoApplicationTests {

    @Autowired
    PersonMapper personMapper;

    @Test
    public void testInsert() {
        int rst = -1;
        Person person = new Person();
        person.setName("tian");
        person.setAge(22);
        try {
            rst = personMapper.insert(person);
        }catch (Exception e){
            log.info("insert fail,person:{}",person.toString(),e);
        }
        System.out.println("rst:"+rst);
        System.out.println("id:"+person.getId());
    }

    @Test
    public void testInsertBatch() {
        int rst = -1;
        Person person = new Person();
        person.setName("tian");
        person.setAge(22);

        Person person1 = new Person();
        person1.setName("doinb");
        person1.setAge(22);

        Person person2 = new Person();
        person2.setName("lwx");
        person2.setAge(20);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        personList.add(person2);

        try {
            rst = personMapper.insertBatch(personList);
        }catch (Exception e){
            log.info("insert fail,person:{}",personList,e);
        }
        System.out.println("rst:"+rst);
    }

    @Test
    public void testSelect() {
        List<Person> personList = personMapper.select();
        personList.forEach(e->System.out.println(e));
    }


    @Test
    public void testDelete() {
        int rst = personMapper.delete(1);
        System.out.println(rst);
    }

    @Test
    public void testUpdate() {

        Person person1 = new Person();
        person1.setId(99);
        person1.setName("doinb666");
        person1.setAge(23);

        int rst = personMapper.update(person1);
        System.out.println(rst);
    }

    @Test
    public void testUpdateByCondition() {

        Person personUpdate = new Person();
        personUpdate.setName("新名字");
        personUpdate.setAge(999);

        Person personCondition = new Person();
        personCondition.setId(5);

        int rst = personMapper.updateByCondition(personUpdate,personCondition);
        Assert.assertEquals(rst,1);
    }

}
