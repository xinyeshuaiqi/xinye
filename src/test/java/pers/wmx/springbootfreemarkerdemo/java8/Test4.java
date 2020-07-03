package pers.wmx.springbootfreemarkerdemo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.base.Function;

/**
 * @author: wangmingxin03
 * @date: 2020-07-03
 */
public class Test4 {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(20);
        Person p2 = new Person();
        p2.setName("李四");
        p2.setAge(21);
        Person p3 = new Person();
        p3.setName("王五");
        p3.setAge(18);

        people.add(p1);
        people.add(p2);
        people.add(p3);

        IntStream ageStream = people.stream().mapToInt(Person::getAge);

        //求合
        System.out.println(ageStream.sum());

        //再次求合  stream has already been operated upon or closed
        //System.out.println(ageStream.sum());

        int maxAge = people.stream()
                .mapToInt(Person::getAge).max().orElse(0);
        System.out.println(maxAge);

        int minAge = people.stream()
                .mapToInt(Person::getAge).min().orElse(0);
        System.out.println(minAge);

        //过滤大于等于20岁的人
        Predicate<Integer> agePredicate = (age) -> age >= 20;
        List<Person> oldPeople = people.stream()
                .filter(person -> agePredicate.test(person.getAge()))
                .collect(Collectors.toList());
        System.out.println(oldPeople);


        Supplier<Person> getInstance = () -> new Person("xx", 18);
        System.out.println(getInstance.get());


        Consumer<Person> personConsumer =
                (Person p) -> System.out.println("幸运儿 " + p.getName());
        personConsumer.accept(p1);


        Function<Person, String> nickNameFunction =
                (Person p) -> p.getName() + "_帅气";
        List<String> nickNameList =
                people.stream().map(nickNameFunction).collect(Collectors.toList());
        System.out.println(nickNameList);



        //又来了一批年龄大的people list
        List<Person> people1 = new ArrayList<>();

        Person p4 = new Person();
        p4.setName("赵六");
        p4.setAge(40);
        Person p5 = new Person();
        p5.setName("王二麻子");
        p5.setAge(99);
        Person p6 = new Person();
        p6.setName("赵二瘸子");
        p6.setAge(200);

        people1.add(p4);
        people1.add(p5);
        people1.add(p6);

        List<List<Person>> personList = new ArrayList<>();
        personList.add(people);
        personList.add(people1);

        //想把这两个list合成一个
        List<Person> finalPersonList = personList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(finalPersonList);

        //是否有(存在)大于100岁的
        boolean flag = finalPersonList.stream()
                .anyMatch(person -> person.getAge() > 100);
        System.out.println(flag);

        //求流中的元素个数
        long peopleCount1= finalPersonList.stream().collect(Collectors.counting());
        long peopleCount2= finalPersonList.stream().count();
        System.out.println(peopleCount1);
        System.out.println(peopleCount2);

        //按年龄分组
        Map<Boolean, List<Person>> personMap =
                finalPersonList.stream().collect(Collectors.groupingBy(p -> p.getAge() > 50));
        List<Person> oldPersonList = personMap.get(true);
        List<Person> youngPersonList = personMap.get(false);
        System.out.println(youngPersonList);
        System.out.println(oldPersonList);

    }

}


class Person {
    private String name;

    private int age;

    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}