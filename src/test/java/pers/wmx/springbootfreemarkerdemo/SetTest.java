package pers.wmx.springbootfreemarkerdemo;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * @author wangmingxin03
 * Created on 2022-08-18
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Long> set1 = new HashSet<>();
        set1.add(1L);
        set1.add(2L);

        Set<Long> set2 = new HashSet<>();
        set2.add(1L);
        set2.add(2L);

        System.out.println(set1.equals(set2));
        Set<Long> union = Sets.union(set1, set2);
        System.out.println(union.size() == set1.size());
    }

}
