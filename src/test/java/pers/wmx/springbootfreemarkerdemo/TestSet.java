package pers.wmx.springbootfreemarkerdemo;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * @author: wangmingxin03
 * @date: 2020-08-06
 */
public class TestSet {
    public static void main(String[] args) {
        Set<Integer> s1 = Sets.newHashSet();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);

        Set<Integer> s2 = Sets.newHashSet();
        s2.add(3);
        s2.add(4);
        s2.add(5);
        s2.add(6);

        Set<Integer> difference = Sets.difference(s1, s2);
        System.out.println(difference);
    }

}
