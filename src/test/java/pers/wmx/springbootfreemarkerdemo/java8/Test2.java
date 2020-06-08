package pers.wmx.springbootfreemarkerdemo.java8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.Builder;
import lombok.Data;

/**
 * @author: wangmingxin03
 * @date: 2020-06-08
 */
public class Test2 {
    public static void main(String[] args) {
//        List<Student> students = Lists.newArrayListWithCapacity(3);
//
//        Student student1 = Student.builder().grade("一班").name("小明").hobby(Lists.newArrayList("篮球", "足球")).build();
//        Student student2 = Student.builder().grade("一班").name("小红").hobby(Lists.newArrayList("羽毛球", "篮球")).build();
//        Student student3 = Student.builder().grade("二班").name("小张").hobby(Lists.newArrayList("足球", "毽子")).build();
//
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//
//        Map<String, Set<String>> collect = students.stream().collect(
//                Collectors.groupingBy(Student::getGrade, Collectors.mapping(Student::getHobby, Collectors.collectingAndThen(Collectors.toList(),
//                        (List<Object> hobby) -> {
//                            Set<String> hobbys = new HashSet<>();
//                            for (Object h : hobby) {
//                                hobbys.addAll((List<String>) h);
//                            }
//                            return hobbys;
//                        }))));
//        System.out.println(collect);

        //{一班=[足球, 羽毛球, 篮球], 二班=[足球, 毽子]}

        List<Student> students = Lists.newArrayListWithCapacity(3);

        Student student1 = new Student();
        student1.setName("m");
        student1.setGrade("一班");
        student1.setHobby(Lists.newArrayList("篮球", "足球"));

        Student student2 = new Student();
        student2.setName("h");
        student2.setGrade("一班");
        student2.setHobby(Lists.newArrayList("羽毛球", "篮球"));

        Student student3 = new Student();
        student3.setName("m");
        student3.setGrade("二班");
        student3.setHobby(Lists.newArrayList("足球", "毽子"));

        students.add(student1);
        students.add(student2);
        students.add(student3);

        Map<String, Set<String>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.mapping(Student::getHobby, Collectors.collectingAndThen(Collectors.toList(),
                        (List<Object> hobby) -> {
                            Set<String> hobbys = new HashSet<>();
                            for (Object h : hobby) {
                                hobbys.addAll((List<String>) h);
                            }
                            return hobbys;
                        }))));

        System.out.println(collect);




    }

    static class Student {
        /**
         * 姓名
         */
        private String name;
        /**
         * 班级
         */
        private String grade;
        /**
         * 兴趣爱好
         */
        private List<String> hobby;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public List<String> getHobby() {
            return hobby;
        }

        public void setHobby(List<String> hobby) {
            this.hobby = hobby;
        }
    }

}


