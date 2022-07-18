package pers.wmx.springbootfreemarkerdemo.bytecode;

import java.lang.reflect.Method;

/**
 * @author wangmingxin03
 * Created on 2022-07-18
 */
public class ReflectionTest {
    private static int count = 0;

    public static void print() {
        new Exception("print exception " + ++count).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("pers.wmx.springbootfreemarkerdemo.bytecode.ReflectionTest");
        Method method = clazz.getMethod("print");

        for (int i = 0; i < 20; i++) {
            method.invoke(null);
        }
    }
}
