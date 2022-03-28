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

        Map<Integer, Integer> map = list.stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity(), (a, b) -> a));
        System.out.println(map);

        map.computeIfAbsent(5, key -> 555);
        System.out.println(map);

        // 如果 key 对应的 value 不存在，则返回该 null。
        // 如果存在，则返回通过 remappingFunction 重新计算后的值。
        map.computeIfPresent(6, (key,value) -> value + value * 3);
        System.out.println(map);
    }
}
