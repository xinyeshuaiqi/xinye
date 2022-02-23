package pers.wmx.springbootfreemarkerdemo.base.generics;

/**
 * @author wangmingxin03
 * Created on 2022-02-23
 */
public class Test3 {
    public static void main(String[] args) {
        Integer []i = {1, 3, 5, 8, 9};
        fun1(i);
        fun2(i);
    }

    public static <T> T[] fun1(T...arg) {
        return arg;
    }

    public static <T> void fun2(T []param) {
        for(T t : param) {
            System.out.println(t);
        }
    }
}
