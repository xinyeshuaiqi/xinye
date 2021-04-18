package pers.wmx.springbootfreemarkerdemo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.assertj.core.util.Lists;

import com.github.phantomthief.pool.KeyAffinityExecutor;

/**
 * @author wangmingxin03
 * Created on 2021-04-15
 */
public class AffinityThreadPool {
    static KeyAffinityExecutor executor =
            KeyAffinityExecutor.newSerializingExecutor(8, 200, "MY-POOL");

    static ExecutorService normalExecutor = Executors.newFixedThreadPool(8);


    public static void main(String[] args) {
        List<Person> personList = mockData();

        // 无法保证顺序性
//        personList.forEach(person -> {
//            normalExecutor.execute(() -> System.out.println(person.getName()));
//        });

        personList.forEach(person -> {
            executor.executeEx(person.getId(), () -> System.out.println(person.getName()));
        });

    }

    private static List<Person> mockData() {
        List<Person> personList = Lists.newArrayList();
        Person p1 = new Person(1, "a");
        Person p2 = new Person(2, "bbb");
        Person p3 = new Person(1, "aaa");
        Person p4 = new Person(1, "aa");
        Person p5 = new Person(2, "b");
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        return personList;
    }
}

class Person {
    private int id;

    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
