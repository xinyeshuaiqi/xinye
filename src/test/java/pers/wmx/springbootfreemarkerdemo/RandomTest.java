package pers.wmx.springbootfreemarkerdemo;

import java.security.SecureRandom;
import java.util.stream.Stream;

/**
 * @author wangmingxin03
 * Created on 2022-11-17
 */
public class RandomTest {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static void main(String[] args) {
        Stream<Double> doubleStream = SECURE_RANDOM.doubles(1, 0, 1.0d)
                .boxed();

        System.out.println(doubleStream.findFirst());

    }
}
