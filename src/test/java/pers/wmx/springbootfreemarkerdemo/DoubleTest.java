package pers.wmx.springbootfreemarkerdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmingxin03
 * Created on 2021-01-22
 */
public class DoubleTest {
    public static void main(String[] args) {
        long a = 10;
        long b = 15;

        double r = (double) b/a;
        System.out.println(r);

        long a1 = 146;
        long b1 = 100;
        System.out.println((double)a1/b1);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,4);
        map.put(3,5);
        int sum = map.values().stream().mapToInt(Integer::valueOf).sum();
        System.out.println(sum);

        long x = 4 * 20 / 100;  // 0
        System.out.println(x);
        long y = 5 * 20 / 100;  // 1
        System.out.println(y);

        long z = 4 * (20 / 100);
        System.out.println(z);
    }
}
