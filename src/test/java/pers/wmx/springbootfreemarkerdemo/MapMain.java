package pers.wmx.springbootfreemarkerdemo;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

/**
 * @author wangmingxin03
 * Created on 2021-01-13
 */
public class MapMain {
    public static void main(String[] args) {
        List<Integer> list = ImmutableList.of(1,2,3,1);

        Map<Integer, Integer> collect = list.stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity(), (a, b) -> a));
        System.out.println(collect);
    }
}
