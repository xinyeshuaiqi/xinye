package pers.wmx.springbootfreemarkerdemo.java8;

/**
 * @author: wangmingxin03
 * @date: 2020-07-03
 */
public class Test3 {
    public static void main(String[] args) {
        int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);

    }
}

interface Converter<T1, T2> {
    void convert(int i);
}
