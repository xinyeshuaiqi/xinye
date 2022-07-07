package pers.wmx.springbootfreemarkerdemo.bytecode;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author wangmingxin03
 * Created on 2022-07-07
 */
public class MethodHandleTest {
    public void print(String s) {
        System.out.println("hello, " + s);
    }

    public static void main(String[] args) throws Throwable {
        MethodHandleTest test = new MethodHandleTest();

        MethodType methodType = MethodType.methodType(void.class, String.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(MethodHandleTest.class,
                "print", methodType);
        methodHandle.invokeExact(test, "nima");
    }
}
